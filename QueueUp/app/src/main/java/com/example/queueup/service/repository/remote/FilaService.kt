package com.example.queueup.service.repository.remote

import androidx.lifecycle.MutableLiveData
import com.example.queueup.service.model.FilaHeaderModel
import feign.Param
import feign.RequestLine
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface FilaService {

    @POST("/fila/entrar")
    fun entrarFila(@Body fila: FilaHeaderModel): Call<List<FilaHeaderModel>>

    @POST("fila/remover/{restaurante}")
    fun remover(
        @Path(value = "restaurante", encoded = true) restaurante: String
    ): Call<List<FilaHeaderModel>>

    @GET("/fila/posicao/{restaurante}/{cliente}")
    fun atualizaPosicao(
        @Path(value = "restaurante", encoded = true) restaurante: String,
        @Path(value = "cliente", encoded = true) cliente: String
    ): Call<Int>

    @GET("/fila/filaPorRestaurante/{idRestaurante}")
    fun filaPorRestaurante(@Path(value = "idRestaurante", encoded = true) idRestaurante: String
    ): Call<List<FilaHeaderModel>>

    @GET("/fila/filaTotalRestaurante/{idRestaurante}")
    fun filaTotalRestaurante(@Path(value = "idRestaurante", encoded = true)idRestaurante: String
    ): Call<Int>
}