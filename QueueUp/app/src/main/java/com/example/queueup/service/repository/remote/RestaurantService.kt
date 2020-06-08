package com.example.queueup.service.repository.remote

import com.example.queueup.service.model.RestaurantHeaderModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface RestaurantService {

    @POST("login/restaurante")
    @FormUrlEncoded
    fun loginRestaurant(
        @Field("cnpj") cnpj: String,
        @Field("senha") password: String
    ): Call<RestaurantHeaderModel>

    @POST("restaurantes/criar")
    fun createRestaurant(
        @Body restaurant: RestaurantHeaderModel
    ): Call<RestaurantHeaderModel>
}