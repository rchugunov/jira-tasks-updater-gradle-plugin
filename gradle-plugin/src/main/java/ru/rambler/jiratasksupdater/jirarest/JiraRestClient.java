package ru.rambler.jiratasksupdater.jirarest;

import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.util.stream.Collectors;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JiraRestClient {
    private static JiraRestClient client;
    private JiraRestAuthService authService;
    private JiraRestApiService apiService;
    private Converter<ResponseBody, BaseJiraResponse> converter;

    private JiraRestClient(String jiraEndpoint) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(jiraEndpoint)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        converter = retrofit.responseBodyConverter(new TypeToken<ResponseBody>() {
        }.getType(), new Annotation[0]);

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

    public Converter<ResponseBody, BaseJiraResponse> getConverter() {
        return converter;
    }

    public String errorResponse(ResponseBody responseBody) {
        try {
            String result = new BufferedReader(new InputStreamReader(responseBody.byteStream())).lines()
                    .parallel().collect(Collectors.joining("\n"));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
