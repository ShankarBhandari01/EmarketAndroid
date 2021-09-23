package com.example.emarketapplication.api

import com.example.emarketapplication.modal.Users
import com.example.emarketapplication.response.UserSignupResponse
import com.example.emarketapplication.response.UsersLoginResponse
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

interface ClientsApi {

    @FormUrlEncoded
    @POST("/login")
    suspend fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Response<UsersLoginResponse>


    @POST("/signUp")
    suspend fun Signup(
        @Body users: Users
    ): Response<UserSignupResponse>


    @Multipart
    @PUT("/profile")
    suspend fun uploadImage(
        @Header("authorization") token: String,
        @Part file: MultipartBody.Part
    ): Response<UsersLoginResponse>

    @PUT("/clients/update/{id}")
    suspend fun update(
        @Header("authorization") token: String,
        @Path("id") id: String,
        @Body clients: Users
    ): Response<UsersLoginResponse>


    @FormUrlEncoded
    @POST("clients/resub")
    suspend fun Resubscription(
        @Header("authorization") token: String,
        @Field("title") subscriptionType: String,
        @Field("description") subscriptionTO: String
    ): Response<UsersLoginResponse>


    @GET("/all/request")
    suspend fun loadRequest(
        @Header("authorization") token: String,
    ): Response<UsersLoginResponse>


    @DELETE("/request/delete/{id}")
    suspend fun deleteRequest(
        @Header("authorization") token: String,
        @Path("id") id: String
    ): Response<UsersLoginResponse>
}