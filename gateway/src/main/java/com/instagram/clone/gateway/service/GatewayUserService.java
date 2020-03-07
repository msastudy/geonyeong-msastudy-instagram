package com.instagram.clone.gateway.service;

import com.instagram.clone.common.user.domain.vo.UserCreateRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by geonyeong.kim on 2020-03-08
 */
public interface GatewayUserService {

    @GET("user")
    Call<Void> readUser();

    @POST("user")
    Call<Void> createUser(@Body UserCreateRequest userCreateRequest);

    @PUT("user")
    Call<Void> updateUser();

    @GET("user/{id}/emailvalidation")
    Call<Void> validateUserEmail(@Path("id") String id);
}
