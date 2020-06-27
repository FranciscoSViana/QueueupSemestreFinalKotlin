package com.example.queueup.service.model

import com.google.gson.annotations.SerializedName

data class FilaHeaderModel(

    @SerializedName("idCliente")
    var idCliente: String?,

    @SerializedName("idRestaurante")
    var idRestaurante: String?,

    @SerializedName("posicao")
    var posicao: Int?
)