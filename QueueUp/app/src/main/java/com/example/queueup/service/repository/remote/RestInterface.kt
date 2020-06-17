package com.example.queueup.service.repository.remote

import com.example.queueup.service.model.RestaurantHeaderModel
import com.example.queueup.service.model.Restaurante
import feign.Param
import feign.RequestLine

interface RestInterface {

    @RequestLine("GET /restaurantes/{tipos}")
    fun getRestaurant(@Param("restaurante") restaurant: String): Restaurante
}