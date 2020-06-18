package com.example.queueup.service.repository.remote

import com.example.queueup.service.model.RestaurantHeaderModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SpecialityService {

    @GET("restaurantes")
    fun all(): Call<List<RestaurantHeaderModel>>

    @GET("restaurantes")
    fun list(): List<RestaurantHeaderModel>

    @GET("restaurantes/especialidades/{tipo}")
    fun listType(@Path(value = "tipo", encoded = true) type: String?): Call<List<RestaurantHeaderModel>>
}