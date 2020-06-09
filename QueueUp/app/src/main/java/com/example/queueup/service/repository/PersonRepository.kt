package com.example.queueup.service.repository

import android.content.Context
import com.example.queueup.R
import com.example.queueup.service.model.PersonHeaderModel
import com.example.queueup.service.constants.TaskConstants
import com.example.queueup.service.listener.APIListener
import com.example.queueup.service.repository.remote.PersonService
import com.example.queueup.service.repository.remote.RetrofitClient
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PersonRepository(val context: Context) {

    private val mRemote = RetrofitClient.createService(PersonService::class.java)

    fun login(cpf: String, password: String, listener: APIListener) {
        val call: Call<PersonHeaderModel> = mRemote.login(cpf, password)
        call.enqueue(object : Callback<PersonHeaderModel> {
            override fun onFailure(call: Call<PersonHeaderModel>, t: Throwable) {
                listener.onFailure(context.getString(R.string.ERROR_UNEXPECTED))
            }

            override fun onResponse(call: Call<PersonHeaderModel>, response: Response<PersonHeaderModel>) {
                if (response.code() != TaskConstants.HTTP.SUCCESS) {
                    val validation =
                        Gson().fromJson(response.errorBody()!!.toString(), String::class.java)
                    listener.onFailure(validation)
                } else {
                    println(response.body()?.cpf)
                    response.body()?.let { listener.onSuccess(it) }
                }
            }

        })
    }

    fun create(name: String, cpf: String, password: String, listener: APIListener) {
        val call: Call<PersonHeaderModel> = mRemote.createUser(name, cpf, password)
        call.enqueue(object : Callback<PersonHeaderModel> {
            override fun onFailure(call: Call<PersonHeaderModel>, t: Throwable) {
                listener.onFailure(context.getString(R.string.ERROR_UNEXPECTED))
            }

            override fun onResponse(call: Call<PersonHeaderModel>, response: Response<PersonHeaderModel>) {
                if (response.code() != TaskConstants.HTTP.SUCCESS) {
                    val validation =response.errorBody()!!.string()
                       // Gson().fromJson(, String::class.java)
                    listener.onFailure(validation)
                } else {
                    response.body()?.let { listener.onSuccess(it) }
                }
            }

        })
    }
}