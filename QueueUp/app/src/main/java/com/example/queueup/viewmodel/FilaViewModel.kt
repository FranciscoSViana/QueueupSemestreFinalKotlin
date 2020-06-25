package com.example.queueup.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.queueup.service.model.FilaHeaderModel
import com.example.queueup.service.repository.remote.FilaService
import com.example.queueup.service.repository.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilaViewModel : ViewModel() {

    val fila: MutableLiveData<List<FilaHeaderModel>> = MutableLiveData()

    fun entrarFila(){
        RetrofitClient.createService(FilaService::class.java).entrarFila()
            .enqueue(object : Callback<FilaHeaderModel>{
                override fun onFailure(call: Call<FilaHeaderModel>, t: Throwable) {
                    TODO("Not yet implemented")
                }

                override fun onResponse(
                    call: Call<FilaHeaderModel>,
                    response: Response<FilaHeaderModel>
                ) {
                    TODO("Not yet implemented")
                }

            })
    }

    fun remover(restaurante: Int){
        RetrofitClient.createService(FilaService::class.java).remover(restaurante)
            .enqueue(object : Callback<FilaHeaderModel>{
                override fun onFailure(call: Call<FilaHeaderModel>, t: Throwable) {
                    TODO("Not yet implemented")
                }

                override fun onResponse(
                    call: Call<FilaHeaderModel>,
                    response: Response<FilaHeaderModel>
                ) {
                    TODO("Not yet implemented")
                }

            })
    }

    fun atualizaPosicao(restaurante: Int, cliente:Int){
        RetrofitClient.createService(FilaService::class.java).atualizaPosicao(restaurante, cliente)
            .enqueue(object : Callback<FilaHeaderModel>{
                override fun onFailure(call: Call<FilaHeaderModel>, t: Throwable) {
                    TODO("Not yet implemented")
                }

                override fun onResponse(
                    call: Call<FilaHeaderModel>,
                    response: Response<FilaHeaderModel>
                ) {
                    TODO("Not yet implemented")
                }

            })
    }

    fun filaPorRestaurante(idRestaurante: Int){
        RetrofitClient.createService(FilaService::class.java).filaPorRestaurante(idRestaurante)
            .enqueue(object : Callback<List<FilaHeaderModel>>{
                override fun onFailure(call: Call<List<FilaHeaderModel>>, t: Throwable) {
                    TODO("Not yet implemented")
                }

                override fun onResponse(
                    call: Call<List<FilaHeaderModel>>,
                    response: Response<List<FilaHeaderModel>>
                ) {
                    TODO("Not yet implemented")
                }

            })
    }

    fun filaTotalRestaurante(idRestaurante: Int){
        RetrofitClient.createService(FilaService::class.java).filaTotalRestaurante(idRestaurante)
            .enqueue(object : Callback<FilaHeaderModel>{
                override fun onFailure(call: Call<FilaHeaderModel>, t: Throwable) {
                    TODO("Not yet implemented")
                }

                override fun onResponse(
                    call: Call<FilaHeaderModel>,
                    response: Response<FilaHeaderModel>
                ) {
                    TODO("Not yet implemented")
                }

            })
    }
}