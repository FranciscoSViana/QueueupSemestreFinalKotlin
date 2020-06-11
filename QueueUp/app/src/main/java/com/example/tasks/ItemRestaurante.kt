package com.example.tasks

class ItemRestaurante {

    var iconeRestaurante:Int ? = 0
    var statusRestaurante:Int ? = 0
    var nomeRestaurante:String ? = null
    var culinariaRestaurante:String ? = null
    var distanciaRestaurante:String ? = null
    var tempoFila:String ? = null

    constructor(
        iconeRestaurante: Int?,
        statusRestaurante: Int?,
        nomeRestaurante: String?,
        culinariaRestaurante: String?,
        distanciaRestaurante: String?,
        tempoFila: String?
    ) {
        this.iconeRestaurante = iconeRestaurante
        this.statusRestaurante = statusRestaurante
        this.nomeRestaurante = nomeRestaurante
        this.culinariaRestaurante = culinariaRestaurante
        this.distanciaRestaurante = distanciaRestaurante
        this.tempoFila = tempoFila
    }
}