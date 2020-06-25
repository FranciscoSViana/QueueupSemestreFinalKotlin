package com.example.queueup.adapters

import com.example.queueup.service.repository.remote.FilaService
import feign.Feign
import feign.gson.GsonDecoder
import feign.gson.GsonEncoder

object Restaurante {

    fun criar(): FilaService {
        return Feign.builder()
            .decoder(GsonDecoder())
            .encoder(GsonEncoder())
            .target(
                FilaService::class.java,
                "http://queueup-backend-lb-437808896.us-east-1.elb.amazonaws.com/"
            )

    }
}