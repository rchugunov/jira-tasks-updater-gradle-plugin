package ru.rambler.jiratasksupdater.jirarest;


import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JiraRestApiService {
    //    @FormUrlEncoded
//    @POST("oauth2/v4/token")
//    Call<GApiOAuthResponse> getTokenData(@Field("grant_type") String grantType,
//                                         @Field("assertion") String jwt);
//
    @GET("rest/api/2/issue/{issueId}/editmeta")
    @Headers("Content-Type: application/json")
    Call<JiraIssueEditMeta> getIssueEditMeta(@Path("issueId") String issueId,
                                             @Header("Authorization") String basic);

    @PUT("rest/api/2/issue/{issueId}")
    @Headers("Content-Type: application/json")
    Call<Response> updateJiraIssueFixedVersion(@Path("issueId") String issueId,
                                               @Header("Authorization") String basic,
                                               @Query("notifyUsers") boolean notifyUsers,
                                               @Body JiraFixedVersionRequest request);

    @PUT("rest/api/2/issue/{issueId}")
    @Headers("Content-Type: application/json")
    Call<List<JiraProjectVersion>> getTransitions(@Path("issueId") String issueId,
                                                  @Header("Authorization") String basic,
                                                  @Query("notifyUsers") boolean notifyUsers,
                                                  @Query("overrideScreenSecurity") boolean overrideScreenSecurity);

    @PUT("rest/api/2/issue/{issueId}")
    @Headers("Content-Type: application/json")
    Call<List<JiraProjectVersion>> doTransition(@Path("issueId") String issueId,
                                                @Header("Authorization") String basic,
                                                @Query("notifyUsers") boolean notifyUsers,
                                                @Query("overrideScreenSecurity") boolean overrideScreenSecurity);
}
