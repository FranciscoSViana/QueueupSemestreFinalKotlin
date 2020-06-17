package com.example.queueup.adapters

import com.example.queueup.service.repository.remote.RestInterface
import com.example.queueup.service.repository.remote.RestaurantService
import com.google.gson.Gson
import feign.Feign
import feign.gson.GsonDecoder
import feign.gson.GsonEncoder

object Restaurante {

    fun criar(): RestInterface {
        return Feign.builder()
            .decoder(GsonDecoder())
            .encoder(GsonEncoder())
            .target(
                RestInterface::class.java,
                "http://queueup-backend-lb-437808896.us-east-1.elb.amazonaws.com/"
            )

    }
}