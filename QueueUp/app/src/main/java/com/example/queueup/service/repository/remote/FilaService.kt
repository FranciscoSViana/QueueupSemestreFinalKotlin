package com.example.queueup.service.repository.remote

import com.example.queueup.service.model.FilaHeaderModel
import feign.Param
import feign.RequestLine
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface FilaService {

    @POST("/fila/entrar")
    fun entrarFila(): Call<FilaHeaderModel>

    @POST("fila/remover/{restaurante}")
    fun remover(
        @Path(value = "restaurante", encoded = true) restaurante: Int
    ): Call<FilaHeaderModel>

    @GET("/fila/posicao/{restaurante}/{cliente}")
    fun atualizaPosicao(
        @Path(value = "restaurante", encoded = true) restaurante: Int,
        @Path(value = "cliente", encoded = true) cliente: Int
    ): Call<FilaHeaderModel>

    @GET("/fila/filaPorRestaurante/{idRestaurante}")
    fun filaPorRestaurante(@Path(value = "idRestaurante", encoded = true) idRestaurante: Int
    ): Call<List<FilaHeaderModel>>

    @GET("/fila/filaTotalRestaurante/{idRestaurante}")
    fun filaTotalRestaurante(@Path(value = "idRestaurante", encoded = true)idRestaurante: Int
    ): Call<FilaHeaderModel>
}