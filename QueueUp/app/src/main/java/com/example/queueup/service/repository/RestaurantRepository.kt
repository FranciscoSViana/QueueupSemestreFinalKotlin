package com.example.queueup.service.repository

import android.content.Context
import com.example.queueup.R
import com.example.queueup.service.constants.TaskConstants
import com.example.queueup.service.listener.APIRestaurantListener
import com.example.queueup.service.model.RestaurantHeaderModel
import com.example.queueup.service.repository.remote.RestaurantService
import com.example.queueup.service.repository.remote.RetrofitClient
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestaurantRepository(val context: Context) {

    private val mRemote = RetrofitClient.createService(RestaurantService::class.java)

    fun login(cnpj: String, password: String, listener: APIRestaurantListener) {
        val call: Call<RestaurantHeaderModel> = mRemote.loginRestaurant(cnpj, password)
        call.enqueue(object : Callback<RestaurantHeaderModel> {
            override fun onFailure(call: Call<RestaurantHeaderModel>, t: Throwable) {
                listener.onFailure(context.getString(R.string.ERROR_UNEXPECTED))
            }

            override fun onResponse(
                call: Call<RestaurantHeaderModel>,
                response: Response<RestaurantHeaderModel>
            ) {
                if (response.code() != TaskConstants.HTTP.SUCCESS) {
                    val validation =
                        Gson().fromJson(response.errorBody()!!.string(), String::class.java)
                    listener.onFailure(validation)
                } else {
                    println(response.body()?.cnpj)
                    response.body()?.let { listener.onSuccess(it) }
                }
            }

        })
    }

    fun create(
        restaurant: RestaurantHeaderModel,
        listener: APIRestaurantListener
    ) {
        val call: Call<RestaurantHeaderModel> = mRemote.createRestaurant(restaurant)
        call.enqueue(object : Callback<RestaurantHeaderModel> {
            override fun onFailure(call: Call<RestaurantHeaderModel>, t: Throwable) {
                listener.onFailure(context.getString(R.string.ERROR_UNEXPECTED))
            }

            override fun onResponse(
                call: Call<RestaurantHeaderModel>,
                response: Response<RestaurantHeaderModel>
            ) {
                if (response.code() != TaskConstants.HTTP.SUCCESS) {
                    val validation = response.errorBody()!!.string()
                    //Gson().fromJson(, String::class.java)
                    listener.onFailure(validation)
                } else {
                    response.body()?.let { listener.onSuccess(it) }
                }
            }

        })
    }
}