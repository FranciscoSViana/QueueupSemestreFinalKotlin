package com.example.queueup.service.model

import com.google.gson.annotations.SerializedName

class PersonHeaderModel {

    @SerializedName("cpf")
    var cpf: String = ""

    @SerializedName("senha")
    var password: String = ""

    @SerializedName("nome")
    var name: String = ""
}