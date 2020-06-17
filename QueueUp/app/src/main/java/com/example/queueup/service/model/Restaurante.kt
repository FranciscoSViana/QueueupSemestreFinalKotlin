package com.example.queueup.service.model

data class Restaurante(
    val nome: String,
    val cidade: String,
    val estado: String,
    val bairro: String,
    val logradouro: String,
    val numEndereco: String,
    val cep: String,
    val telefone: String,
    val tipo: String,
    val capacidade: Int
)