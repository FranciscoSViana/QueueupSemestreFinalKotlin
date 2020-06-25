package com.example.queueup.service.model

import com.google.gson.annotations.SerializedName

data class FilaHeaderModel(

    @SerializedName("idCliente")
    var idCliente: Int?,

    @SerializedName("idRestaurante")
    var idRestaurante: Int?,

    @SerializedName("posicao")
    var posicao: Int?
)