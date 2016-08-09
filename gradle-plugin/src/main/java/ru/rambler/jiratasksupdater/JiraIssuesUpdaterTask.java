package ru.rambler.jiratasksupdater;


import org.gradle.api.DefaultTask;
import org.gradle.api.GradleException;
import org.gradle.api.tasks.TaskAction;

import java.io.IOException;

import retrofit2.Call;
import ru.rambler.jiratasksupdater.jirarest.JiraProjectVersionsResponse;
import ru.rambler.jiratasksupdater.jirarest.JiraRestClient;

public class JiraIssuesUpdaterTask extends DefaultTask {
    @TaskAction
    public void run() {
        JiraTasksUpdaterExtension extension = getProject().getExtensions().findByType(JiraTasksUpdaterExtension.class);
        JiraRestClient client = JiraRestClient.getInstance(extension.getJiraEndpoint());
        Call<JiraProjectVersionsResponse> responseCall = client.getApiService().getProjectVersions(extension.getProjectId(),
                Base64Helper.encode(extension.getUsername() + ":" + extension.getPassword()));
        try {
            JiraProjectVersionsResponse response = responseCall.execute().body();
            handleResponse(response);
        } catch (IOException e) {
            throw new GradleException(e.getMessage(), e);
        }
    }

    private void handleResponse(JiraProjectVersionsResponse response) {

    }
}
