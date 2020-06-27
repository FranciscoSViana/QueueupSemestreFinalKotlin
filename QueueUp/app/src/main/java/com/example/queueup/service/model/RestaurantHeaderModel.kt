package com.example.queueup.service.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "tb_restaurante")
class RestaurantHeaderModel(

    @SerializedName("idRestaurante")
    var idRestaurante: String,

    @SerializedName("nome")
    var name: String?,

    @SerializedName("cnpj")
    var cnpj: String?,

    @SerializedName("cidade")
    var city: String?,

    @SerializedName("estado")
    var state: String?,

    @SerializedName("bairro")
    var district: String?,

    @SerializedName("logradouro")
    var street: String?,

    @SerializedName("numEndereco")
    var number: String?,

    @SerializedName("cep")
    var cep: String?,

    @SerializedName("telefoneRestaurante")
    var telephone: String?,

    @SerializedName("senha")
    var password: String?,

    @SerializedName("tipo")
    var type: String?,

    @SerializedName("imagem")
    var imagem: String?,

    @SerializedName("logo")
    var logo: String?

//    @SerializedName("capacidade")
//    var capacity: String

)