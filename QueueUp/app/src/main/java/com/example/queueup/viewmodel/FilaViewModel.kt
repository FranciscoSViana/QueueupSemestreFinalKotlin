package com.example.queueup.viewmodel

import android.content.Intent
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.queueup.service.model.FilaHeaderModel
import com.example.queueup.service.repository.local.SecurityPreferences
import com.example.queueup.service.repository.remote.FilaService
import com.example.queueup.service.repository.remote.RetrofitClient
import com.example.queueup.view.FilaInfo
import com.example.queueup.view.QueueTimeActivity
import com.example.queueup.view.RestaurantDetailsActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import java.util.logging.Handler
import kotlin.Int as Int1

class FilaViewModel : ViewModel() {

    val rest: MutableLiveData<List<FilaHeaderModel>> = MutableLiveData()
    private lateinit var save: SecurityPreferences
    var qtd: Int1 = 0
    var posicao: Int1 = 0
    fun entrarFila(fila: FilaHeaderModel) {
        RetrofitClient.createService(FilaService::class.java).entrarFila(fila)
            .enqueue(object : Callback<List<FilaHeaderModel>> {
                override fun onFailure(call: Call<List<FilaHeaderModel>>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<List<FilaHeaderModel>>,
                    response: Response<List<FilaHeaderModel>>
                ) {
                    if (response.isSuccessful) {
                        val filas: MutableList<FilaHeaderModel> = mutableListOf()
                        response.body()?.let {
                            for (result in it) {
                                Log.d("posição: ", result.posicao.toString())
                                val fila = FilaHeaderModel(
                                    idCliente = result.idCliente,
                                    idRestaurante = result.idRestaurante,
                                    posicao = result.posicao
                                )
                                filas.add(fila)
                            }
                        }
                        rest.value = filas
                    }
                }

            })
    }

    fun remover(restaurante: String) {
        RetrofitClient.createService(FilaService::class.java).remover(restaurante)
            .enqueue(object : Callback<List<FilaHeaderModel>> {
                override fun onFailure(call: Call<List<FilaHeaderModel>>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<List<FilaHeaderModel>>,
                    response: Response<List<FilaHeaderModel>>
                ) {
                    if (response.isSuccessful) {
                        var filas: MutableList<FilaHeaderModel> = mutableListOf()
                        response.body()?.let {
                            for (result in it) {
                                val fila = FilaHeaderModel(
                                    idCliente = result.idCliente,
                                    idRestaurante = result.idRestaurante,
                                    posicao = result.posicao
                                )
                            }
                        }
                    }
                }

            })
    }

    fun atualizaPosicao(idRestaurante: String, idCliente: String, activity: FilaInfo) {

        RetrofitClient.createService(FilaService::class.java)
            .atualizaPosicao(idRestaurante, idCliente)
            .enqueue(object : Callback<Int1> {

                override fun onFailure(call: Call<Int1>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<Int1>,
                    response: Response<Int1>
                ) {

                    posicao = response.body().toString().toInt()

                    Log.d("posicao", posicao.toString())
                    val intent = Intent(activity.applicationContext, QueueTimeActivity::class.java)
                    intent.putExtra("posicao", posicao -1)
                    activity.startActivity(intent)
                }

            })
    }

    fun filaPorRestaurante(idRestaurante: String) {
        RetrofitClient.createService(FilaService::class.java).filaPorRestaurante(idRestaurante)
            .enqueue(object : Callback<List<FilaHeaderModel>> {
                override fun onFailure(call: Call<List<FilaHeaderModel>>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<List<FilaHeaderModel>>,
                    response: Response<List<FilaHeaderModel>>
                ) {
                    if (response.isSuccessful) {
                        var filas: MutableList<FilaHeaderModel> = mutableListOf()
                        response.body()?.let {
                            for (result in it) {
                                val fila = FilaHeaderModel(
                                    idCliente = result.idCliente,
                                    idRestaurante = result.idRestaurante,
                                    posicao = result.posicao
                                )
                            }
                        }
                    }
                }

            })
    }

    fun filaTotalRestaurante(idRestaurante: String, activity: RestaurantDetailsActivity) {
        RetrofitClient.createService(FilaService::class.java).filaTotalRestaurante(idRestaurante)
            .enqueue(object : Callback<Int1> {
                override fun onFailure(call: Call<Int1>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<Int1>,
                    response: Response<Int1>
                ) {

                    qtd = response.body().toString().toInt()
                    Log.d("qtd", qtd.toString())
                    val intent = Intent(activity.applicationContext, FilaInfo::class.java)
                    intent.putExtra("qtdFila", qtd)
                    activity.startActivity(intent)

                }

            })
    }
}