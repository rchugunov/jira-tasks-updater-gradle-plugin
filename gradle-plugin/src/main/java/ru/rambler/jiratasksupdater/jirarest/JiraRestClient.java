package ru.rambler.jiratasksupdater.jirarest;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JiraRestClient {
    private static JiraRestClient client;
    JiraRestAuthService authService;
    JiraRestApiService apiService;

    private JiraRestClient(String jiraEndpoint) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(jiraEndpoint)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        authService = retrofit.create(JiraRestAuthService.class);
        apiService = retrofit.create(JiraRestApiService.class);
    }

    public static JiraRestClient getInstance(String jiraEndpoint) {
        if (client == null) {
            client = new JiraRestClient(jiraEndpoint);
        }
        return client;
    }

    public JiraRestAuthService getAuthService() {
        return authService;
    }

    public JiraRestApiService getApiService() {
        return apiService;
    }
}
