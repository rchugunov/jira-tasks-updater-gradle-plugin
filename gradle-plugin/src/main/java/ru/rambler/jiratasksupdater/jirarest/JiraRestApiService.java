package ru.rambler.jiratasksupdater.jirarest;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

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

//    @PUT("rest/api/2/issue/{issueId}")
//    @Headers("Content-Type: application/json")
//    Call<Response> updateJiraIssueFixedVersion(@Path("issueId") String issueId,
//                                               @Header("Authorization") String basic,
//                                               @Query("notifyUsers") boolean notifyUsers,
//                                               @Body JiraFixedVersionRequest request);

    @GET("rest/api/2/issue/{issueId}/?expand=transitions")
    @Headers("Content-Type: application/json")
    Call<JiraIssueStatusReponse> getIssueStatus(@Path("issueId") String issueId,
                                                @Header("Authorization") String basic);

    @POST("rest/api/2/issue/{issueId}/transitions")
    @Headers("Content-Type: application/json")
    Call<ResponseBody> doTransition(@Path("issueId") String issueId,
                                    @Header("Authorization") String basic,
                                    @Body JiraIssue jiraIssue);
}
