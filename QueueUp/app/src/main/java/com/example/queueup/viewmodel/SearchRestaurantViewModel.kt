package com.example.queueup.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.queueup.service.model.RestaurantHeaderModel
import com.example.queueup.service.repository.remote.RetrofitClient
import com.example.queueup.service.repository.remote.SpecialityService
import com.example.tasks.ItemRestaurante
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchRestaurantViewModel : ViewModel() {

    val restaurants: MutableLiveData<List<RestaurantHeaderModel>> = MutableLiveData()



    fun getRestaurante(str: String?) {
        RetrofitClient.createService(SpecialityService::class.java).listType(str)
            .enqueue(object : Callback<List<RestaurantHeaderModel>> {
                override fun onFailure(call: Call<List<RestaurantHeaderModel>>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<List<RestaurantHeaderModel>>,
                    response: Response<List<RestaurantHeaderModel>>
                ) {
                    if (response.isSuccessful) {
                        val restaurantes: MutableList<RestaurantHeaderModel> = mutableListOf()
                        response.body()?.let {
                            for (result in it) {
                                Log.d("Nome: ", result.name.toString())
                                val restaurante = RestaurantHeaderModel(
                                    idRestaurante = result.idRestaurante,
                                    name = result.name,
                                    cnpj = result.cnpj,
                                    city = result.city,
                                    state = result.state,
                                    district = result.district,
                                    street = result.street,
                                    number = result.number,
                                    cep = result.cep,
                                    telephone = result.telephone,
                                    password = result.password,
                                    type = result.type,
                                    imagem = result.imagem,
                                    logo = result.logo
                                    //arrumar o capacity
                                    //capacity = result.capacity
                                )
                                restaurantes.add(restaurante)
                            }
                        }
                        restaurants.value = restaurantes
                    }

                }

            })
    }

    fun all() {
        RetrofitClient.createService(SpecialityService::class.java).all()
            .enqueue(object : Callback<List<RestaurantHeaderModel>> {
                override fun onFailure(call: Call<List<RestaurantHeaderModel>>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<List<RestaurantHeaderModel>>,
                    response: Response<List<RestaurantHeaderModel>>
                ) {
                    if (response.isSuccessful) {
                        val restaurantes: MutableList<RestaurantHeaderModel> = mutableListOf()
                        response.body()?.let {
                            for (result in it) {
                                val restaurante = RestaurantHeaderModel(
                                    idRestaurante = result.idRestaurante,
                                    name = result.name,
                                    cnpj = result.cnpj,
                                    city = result.city,
                                    state = result.state,
                                    district = result.district,
                                    street = result.street,
                                    number = result.number,
                                    cep = result.cep,
                                    telephone = result.telephone,
                                    password = result.password,
                                    type = result.type,
                                    imagem = result.imagem,
                                    logo = result.logo
                                )
                                restaurantes.add(restaurante)
                            }
                        }
                        restaurants.value = restaurantes
                    }
                }

            })
    }

}