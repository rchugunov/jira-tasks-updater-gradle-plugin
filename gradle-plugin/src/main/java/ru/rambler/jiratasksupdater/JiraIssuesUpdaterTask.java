package ru.rambler.jiratasksupdater;


import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.StopActionException;
import org.gradle.api.tasks.TaskAction;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import ru.rambler.jiratasksupdater.jirarest.BaseJiraResponse;
import ru.rambler.jiratasksupdater.jirarest.JiraProjectVersion;
import ru.rambler.jiratasksupdater.jirarest.JiraRestClient;

public class JiraIssuesUpdaterTask extends DefaultTask {
    @TaskAction
    public void run() {
        JiraTasksUpdaterExtension extension = getProject().getExtensions().findByType(JiraTasksUpdaterExtension.class);

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

        JiraRestClient client = JiraRestClient.getInstance(extension.getJiraEndpoint());
        Call<List<JiraProjectVersion>> responseCall = client.getApiService().getProjectVersions(extension.getProjectId(),
                "Basic " + Base64Helper.encode(extension.getUsername() + ":" + extension.getPassword()));
        try {
            Response<List<JiraProjectVersion>> response = responseCall.execute();
            List<JiraProjectVersion> jiraProjectVersionsResponse = response.body();
            if (response.isSuccessful()) {
                handleResponse(jiraProjectVersionsResponse);
            } else {
                getLogger().error("Response code: " + response.code() + " " + response.message());

                if (response.errorBody() != null) {
                    BaseJiraResponse errorResponse = client.getConverter().convert(response.errorBody());
                    getLogger().error(errorResponse.toString());
                }
            }
        } catch (Exception e) {
            getLogger().error(e.getMessage(), e);
            throw new StopActionException(e.getMessage());
        }
    }

    private void handleResponse(List<JiraProjectVersion> response) {
        getLogger().debug("JiraProjectVersionResponse: " + response.toString());
    }
}
