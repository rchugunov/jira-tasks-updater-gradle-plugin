package ru.rambler.jiratasksupdater;


import com.google.gson.Gson;

import org.gradle.api.Action;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.StopActionException;
import org.gradle.api.tasks.TaskAction;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import ru.rambler.jiratasksupdater.git.GitDataProvider;
import ru.rambler.jiratasksupdater.jirarest.JiraIssue;
import ru.rambler.jiratasksupdater.jirarest.JiraIssueEditMeta;
import ru.rambler.jiratasksupdater.jirarest.JiraIssueFixVersion;
import ru.rambler.jiratasksupdater.jirarest.JiraIssueStatusReponse;
import ru.rambler.jiratasksupdater.jirarest.JiraRestClient;

import static ru.rambler.jiratasksupdater.jirarest.JiraIssueStatusReponse.Fields.JiraIssueTransitionStatus;

public class JiraIssuesUpdaterTask extends DefaultTask {
    private JiraRestClient client;
    private JiraTasksUpdaterExtension extension;
    private Gson gson = new Gson();

    @TaskAction
    public void run() {
        extension = getProject().getExtensions().findByType(JiraTasksUpdaterExtension.class);

        client = JiraRestClient.getInstance(extension.getJiraEndpoint());

        if (Utils.stringIsEmpty(extension.getJiraEndpoint())) {
            throw new StopActionException("jiraEndpoint param is necessary");
        }

        if (Utils.stringIsEmpty(extension.getUsername())) {
            throw new StopActionException("username param is necessary");
        }

        if (Utils.stringIsEmpty(extension.getPassword())) {
            throw new StopActionException("password param is necessary");
        }

        if (Utils.stringIsEmpty(extension.getProjectId())) {
            throw new StopActionException("projectId param is necessary");
        }

        Set<String> tasks = getGitCommits();
        updateTasksWithLastVersion(tasks);
    }

    private void updateTasksWithLastVersion(Set<String> tasks) {
        for (String issueId : tasks) {
            getLastAvailableVersion(issueId, jiraIssueFixVersion -> {
                checkTasksAreResolved(tasks, stringStringMap -> {
                    getLogger().quiet("Issues for transition  " + stringStringMap.toString());
                    for (Map.Entry<String, String> entry : stringStringMap.entrySet()) {
                        updateTaskWithVersionWithTransition(entry.getKey(), entry.getValue(), jiraIssueFixVersion);
                    }
                });
            });
        }
    }

    private void getLastAvailableVersion(String issueId, Action<JiraIssueFixVersion> result) {
        Call<JiraIssueEditMeta> responseCall = client.getApiService().getIssueEditMeta(issueId,
                "Basic " + Base64Helper.encode(extension.getUsername() + ":" + extension.getPassword()));
        try {

            Response<JiraIssueEditMeta> response = responseCall.execute();
            JiraIssueEditMeta jiraIssueEditMetaResponse = response.body();

            if (response.isSuccessful()) {

                if (jiraIssueEditMetaResponse.getFields() == null ||
                        jiraIssueEditMetaResponse.getFields().getFixVersions() == null ||
                        jiraIssueEditMetaResponse.getFields().getFixVersions().getAllowedValues() == null ||
                        jiraIssueEditMetaResponse.getFields().getFixVersions().getAllowedValues().isEmpty()) {

                    getLogger().error("No available fix versions for issue: " + issueId);
                }

                List<JiraIssueFixVersion> fixVersions = jiraIssueEditMetaResponse.getFields().getFixVersions().getAllowedValues();
                result.execute(fixVersions.get(fixVersions.size() - 1));
            } else {
                getLogger().error("getIssueEditMeta Response code: " +
                        response.code() + " " +
                        response.message() + " IssueId " + issueId);

                if (response.errorBody() != null) {
                    getLogger().error("GetIssueEditMeta issueId " + issueId + " " + client.errorResponse(response.errorBody()));
                }
            }
        } catch (Exception e) {
            getLogger().error(e.getMessage(), e);
            throw new StopActionException(e.getMessage());
        }
    }

    private void updateTaskWithVersionWithTransition(String issueId, String newStatusId, JiraIssueFixVersion jiraIssueFixVersion) {
        JiraIssue jiraIssue = new JiraIssue(new JiraIssue.Update(Collections.singletonList(new JiraIssue.FixVersions(Collections.singletonList(new JiraIssue.FixedVersion(jiraIssueFixVersion.getName()))))), new JiraIssue.Transition(newStatusId));
        Call<ResponseBody> responseCall = client.getApiService().doTransition(issueId,
                "Basic " + Base64Helper.encode(extension.getUsername() + ":" + extension.getPassword()),
                jiraIssue);
        try {

            Response<ResponseBody> response = responseCall.execute();

            if (response.isSuccessful()) {
                getLogger().error("Issue " + issueId + " was moved successfully");
            } else {
                getLogger().error("updateJiraIssueFixedVersion Response code: " +
                        response.code() + " " +
                        response.message() + " IssueId " + issueId);

                if (response.errorBody() != null) {
                    getLogger().error("updateJiraIssueFixedVersion issueId " + issueId + " " + client.errorResponse(response.errorBody()));
                }
            }
        } catch (Exception e) {
            getLogger().quiet(e.getMessage(), e);
            throw new StopActionException(e.getMessage());
        }
    }

    private Set<String> getGitCommits() {
        GitDataProvider provider = new GitDataProvider();
        try {
            provider.init(extension.getProjectId(), getLogger());
            Set<String> tasks = provider.getJiraTasks();
            getLogger().quiet(tasks.toString());
            return tasks;
        } catch (Exception e) {
            getLogger().error(e.getMessage(), e);
            throw new StopActionException(e.getMessage());
        }
    }

    public void checkTasksAreResolved(Set<String> tasks, Action<Map<String, String>> result) {
        Map<String, String> results = new LinkedHashMap<>();
        for (String issueId : tasks) {
            Call<JiraIssueStatusReponse> call = client.getApiService().getIssueStatus(issueId,
                    "Basic " + Base64Helper.encode(extension.getUsername() + ":" + extension.getPassword()));

            try {
                Response<JiraIssueStatusReponse> response = call.execute();

                if (response.isSuccessful()) {
                    JiraIssueStatusReponse jiraIssueStatusReponse = response.body();
                    if (jiraIssueStatusReponse.getFields() != null && jiraIssueStatusReponse.getFields().getStatus() != null) {
                        JiraIssueTransitionStatus issueStatus = jiraIssueStatusReponse.getFields().getStatus();

                        if (issueStatus.getName().equals(extension.getCurrentStatus())) {
                            if (jiraIssueStatusReponse.getTransitions() != null) {
                                for (JiraIssueTransitionStatus status : jiraIssueStatusReponse.getTransitions()) {
                                    if (status.getName().equals(extension.getStatusForTest())) {
                                        results.put(issueId, status.getId());
                                    }
                                }
                            }
                        }
                    }
                } else {
                    getLogger().error("checkTasksAreResolved Response code: " +
                            response.code() + " " +
                            response.message() + " IssueId " + issueId);

                    if (response.errorBody() != null) {
                        getLogger().error("checkTasksAreResolved issueId " + issueId + " " + client.errorResponse(response.errorBody()));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        result.execute(results);
    }

//    private void getJiraVersions(Action<List<JiraProjectVersion>> result) {
//        Call<List<JiraProjectVersion>> responseCall = client.getApiService().getProjectVersions(extension.getProjectId(),
//                "Basic " + Base64Helper.encode(extension.getUsername() + ":" + extension.getPassword()));
//        try {
//            Response<List<JiraProjectVersion>> response = responseCall.execute();
//            List<JiraProjectVersion> jiraProjectVersionsResponse = response.body();
//            if (response.isSuccessful()) {
//                result.execute(jiraProjectVersionsResponse);
//            } else {
//                getLogger().error("Response code: " + response.code() + " " + response.message());
//
//                if (response.errorBody() != null) {
//                    BaseJiraResponse errorResponse = client.getConverter().convert(response.errorBody());
//                    getLogger().error(errorResponse.toString());
//                }
//            }
//        } catch (Exception e) {
//            getLogger().error(e.getMessage(), e);
//            throw new StopActionException(e.getMessage());
//        }
//    }
}
