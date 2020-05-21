package com.example.queueup.service.repository.remote

import com.example.queueup.service.model.HeaderModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface PersonService {

    @POST("login")
    @FormUrlEncoded
    fun login(
        @Field("cpf") cpf: String,
        @Field("senha") password: String
    ): Call<HeaderModel>

    @POST("usuarios/criar")
    @FormUrlEncoded
    fun createUser(
        @Field("nome") name: String,
        @Field("cpf") cpf: String,
        @Field("senha") password: String
    ): Call<HeaderModel>
}