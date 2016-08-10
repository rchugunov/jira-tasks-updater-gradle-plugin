package ru.rambler.jiratasksupdater.jirarest;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface JiraRestApiService {
    //    @FormUrlEncoded
//    @POST("oauth2/v4/token")
//    Call<GApiOAuthResponse> getTokenData(@Field("grant_type") String grantType,
//                                         @Field("assertion") String jwt);
//
    @GET("rest/api/2/project/{projectId}/versions")
    @Headers("Content-Type: application/json")
    Call<List<JiraProjectVersion>> getProjectVersions(@Path("projectId") String projectId,
                                                      @Header("Authorization") String basic);
}
