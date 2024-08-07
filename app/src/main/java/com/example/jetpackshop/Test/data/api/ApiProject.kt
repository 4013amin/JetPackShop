package com.example.jetpackshop.Test.data.api

import com.example.jetpackshop.Test.data.model.UsersModelsNew
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiProject {
    @Multipart
    @POST("upload")
    suspend fun sendRegister(
        @Part image: MultipartBody.Part,
        @Part("username") username: RequestBody,
        @Part("password") password: RequestBody,
        @Part("phone") phone: RequestBody
    ): retrofit2.Response<UsersModelsNew>


    @Multipart
    @POST("/app/login")
    suspend fun sendLogin(
        @Part("username") username: String,
        @Part("password") password: String
    ): Response<UsersModelsNew>

    @Multipart
    @POST("/app/logout")
    suspend fun sendLogout(
        @Part("username") username: String,
        @Part("password") password: String,
    ): Response<UsersModelsNew>

}