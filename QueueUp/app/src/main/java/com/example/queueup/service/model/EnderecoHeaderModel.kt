package com.example.queueup.service.model

import com.google.gson.annotations.SerializedName

class EnderecoHeaderModel(

    @SerializedName("cidade")
    var city: String?,

    @SerializedName("estado")
    var country: String?,

    var bairro: String?,

    @SerializedName("logradouro")
    var streets: String?,

    @SerializedName("numEndereco")
    var number: String?,
    @SerializedName("cep")
    var cep: String?
)