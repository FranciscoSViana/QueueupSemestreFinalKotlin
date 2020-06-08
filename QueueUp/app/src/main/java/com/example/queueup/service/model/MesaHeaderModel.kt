package com.example.queueup.service.model

import com.google.gson.annotations.SerializedName

class MesaHeaderModel {

    @SerializedName("tipo")
    var type: String = ""

    @SerializedName("nMax")
    var nMax: Int = 0

    @SerializedName("nMin")
    var nMin: Int = 0

    @SerializedName("status")
    var status: Boolean = true
}