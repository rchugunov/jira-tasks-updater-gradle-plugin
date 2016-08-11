package ru.rambler.jiratasksupdater;


import org.gradle.api.Action;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.StopActionException;
import org.gradle.api.tasks.TaskAction;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import ru.rambler.jiratasksupdater.git.GitDataProvider;
import ru.rambler.jiratasksupdater.jirarest.BaseJiraResponse;
import ru.rambler.jiratasksupdater.jirarest.JiraFixedVersionRequest;
import ru.rambler.jiratasksupdater.jirarest.JiraIssue;
import ru.rambler.jiratasksupdater.jirarest.JiraIssueEditMeta;
import ru.rambler.jiratasksupdater.jirarest.JiraIssueFixVersion;
import ru.rambler.jiratasksupdater.jirarest.JiraRestClient;

public class JiraIssuesUpdaterTask extends DefaultTask {
    private JiraRestClient client;
    private JiraTasksUpdaterExtension extension;

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

        if (Utils.stringIsEmpty(extension.getBranch())) {
            throw new StopActionException("branch param is necessary");
        }

        List<String> tasks = getGitCommits();
        updateTasksWithLastVersion(tasks);

        moveTasksToNextStage(tasks, extension.getBranch(), extension.getStage());
    }

    private void updateTasksWithLastVersion(List<String> tasks) {
        for (String issueId : tasks) {
            getLastAvailableVersion(issueId, jiraIssueFixVersion -> updateTaskWithVersion(issueId, jiraIssueFixVersion));
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
                    BaseJiraResponse errorResponse = client.getConverter().convert(response.errorBody());
                    getLogger().error("GetIssueEditMeta issueId " + issueId + " " + errorResponse.toString());
                }
            }
        } catch (Exception e) {
            getLogger().error(e.getMessage(), e);
            throw new StopActionException(e.getMessage());
        }
    }

    private void updateTaskWithVersion(String issueId, JiraIssueFixVersion jiraIssueFixVersion) {
        JiraFixedVersionRequest request = new JiraFixedVersionRequest();
        JiraIssue.Update update = new JiraIssue.Update();
        update.setFixVersions(new JiraIssue.Update.FixVersions(jiraIssueFixVersion));
        request.setUpdate(update);
        Call<Response> responseCall = client.getApiService().updateJiraIssueFixedVersion(issueId,
                "Basic " + Base64Helper.encode(extension.getUsername() + ":" + extension.getPassword()),
                false,
                request);
        try {

            Response<Response> response = responseCall.execute();

            if (response.isSuccessful()) {

            } else {
                getLogger().error("updateJiraIssueFixedVersion Response code: " +
                        response.code() + " " +
                        response.message() + " IssueId " + issueId);

                if (response.errorBody() != null) {
                    BaseJiraResponse errorResponse = client.getConverter().convert(response.errorBody());
                    getLogger().error("updateJiraIssueFixedVersion issueId " + issueId + " " + errorResponse.toString());
                }
            }
        } catch (Exception e) {
            getLogger().error(e.getMessage(), e);
            throw new StopActionException(e.getMessage());
        }
    }

    private void moveTasksToNextStage(List<String> tasks, String branch, String stage) {

    }

    private List<String> getGitCommits() {
        GitDataProvider provider = new GitDataProvider();
        try {
            provider.init(extension.getProjectId(), extension.getBranch(), getLogger());
            List<String> tasks = provider.getJiraTasks();
            getLogger().quiet(tasks.toString());
            return tasks;
        } catch (Exception e) {
            getLogger().error(e.getMessage(), e);
            throw new StopActionException(e.getMessage());
        }
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
