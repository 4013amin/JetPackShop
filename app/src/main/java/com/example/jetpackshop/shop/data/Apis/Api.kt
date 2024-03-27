package com.example.jetpackshop.shop.data.Apis

import com.example.jetpackshop.shop.data.models.Users_Model
import com.example.jetpackshop.shop.data.models.Users_ModelItem
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {

    @POST("/app/create_user")
    suspend fun send_data(
        @Body users: Users_ModelItem
    ): Response<Users_ModelItem>


    @GET("/app/get_all_users")
    suspend fun get_data(): Response<Users_Model>

}