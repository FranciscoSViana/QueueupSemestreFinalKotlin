package com.example.queueup.service.model

import com.google.gson.annotations.SerializedName

class RestaurantHeaderModel(

    @SerializedName("nome")
    var name: String?,

    @SerializedName("cnpj")
    var cnpj: String?,

    @SerializedName("senha")
    var password: String?,

    @SerializedName("endereco")
    var endereco: EnderecoHeaderModel?,

    @SerializedName("telefoneRestaurante")
    var telephone: String?,

    @SerializedName("tipo")
    var tipo: String?,

    @SerializedName("capacidade")
    var capacidade: MesaHeaderModel?

)