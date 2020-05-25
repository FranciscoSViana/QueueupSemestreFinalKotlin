package com.example.queueup.service.model

import com.google.gson.annotations.SerializedName

class RestaurantHeaderModel {

    @SerializedName("nome")
    var name: String = ""

    @SerializedName("cnpj")
    var cnpj: String = ""

    @SerializedName("senha")
    var password = ""

    @SerializedName("cidade")
    var city: String = ""

    @SerializedName("estado")
    var country: String = ""

    @SerializedName("logradouro")
    var streets: String = ""

    @SerializedName("numEndereco")
    var nummber: String = ""

    @SerializedName("cep")
    var cep: String = ""

    @SerializedName("telefoneRestaurante")
    var telephone: String = ""

    @SerializedName("tipo")
    var type: String = ""

    @SerializedName("nMax")
    var nMax: Int = 0

    @SerializedName("nMin")
    var nMin: Int = 0

    @SerializedName("status")
    var status: Boolean = true


}