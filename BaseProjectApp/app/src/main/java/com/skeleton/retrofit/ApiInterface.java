package com.skeleton.retrofit;


import com.skeleton.model.MainClass;
import com.skeleton.model.PostClass;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

import static com.skeleton.constant.ApiKeyConstant.AUTHORIZATION;

/**
 * Developer: Saurabh Verma
 * Dated: 27-09-2016.
 */
public interface ApiInterface {
    String UPDATE_LOCATION = "api/v1/user/updateLocation";





//    /**
//     * @param map
//     * @return
//     */
//    @Multipart
//    @POST("api/v1/user/createUser")
//    Call<LoginResponse> register(@PartMap HashMap<String, RequestBody> map);
//
//
//    /**
//     * @param map
//     * @return
//     */
//    @FormUrlEncoded
//    @PUT("api/v1/user/socialLogin")
//    Call<LoginResponse> socialLogin(@FieldMap HashMap<String, String> map);
//
//    /**
//     * @param authorization
//     * @param map
//     * @return
//     */
//    @FormUrlEncoded
//    @PUT("api/v1/user/loginToken")
//    Call<LoginResponse> accessTokenLogin(@Header(AUTHORIZATION) String authorization,
//                                         @FieldMap HashMap<String, String> map);
//
//
//    /**
//     * @param email
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("api/v1/user/forgotpassword")
//    Call<CommonResponse> forgotPassword(@Field("email") String email);
//
//    /**
//     * @param map
//     * @return
//     */
//    @FormUrlEncoded
//    @PUT("api/v1/user/loginCredential")
//    Call<LoginResponse> login(@FieldMap HashMap<String, String> map);


    /**
     * Update location call.
     *
     * @param authorization the authorization
     * @param map           the map
     * @return the call
     */
    @FormUrlEncoded
    @POST(UPDATE_LOCATION)
    Call<CommonParams> updateLocation(@Header(AUTHORIZATION) String authorization,
                                      @FieldMap HashMap<String, String> map);

    @GET("users")
    Call<List<MainClass>> getUsers();
    @GET("posts")
    Call<List<PostClass>> getPosts(@Query("userId") int id);

}

