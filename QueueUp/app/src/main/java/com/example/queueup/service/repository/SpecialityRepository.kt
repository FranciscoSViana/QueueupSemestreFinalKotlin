package com.example.queueup.service.repository

import android.content.Context
import com.example.queueup.R
import com.example.queueup.service.constants.TaskConstants
import com.example.queueup.service.listener.APIRestaurantListener
import com.example.queueup.service.model.RestaurantHeaderModel
import com.example.queueup.service.repository.remote.RetrofitClient
import com.example.queueup.service.repository.remote.SpecialityService
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SpecialityRepository(val context: Context) : BaseRepository(context) {

    private val mRemote = RetrofitClient.createService(SpecialityService::class.java)

    fun all(listener: APIRestaurantListener<List<RestaurantHeaderModel>>) {
        val call: Call<List<RestaurantHeaderModel>> = mRemote.all()
        call.enqueue(object : Callback<List<RestaurantHeaderModel>> {
            override fun onFailure(call: Call<List<RestaurantHeaderModel>>, t: Throwable) {
                listener.onFailure(context.getString(R.string.ERROR_UNEXPECTED))
            }

            override fun onResponse(
                call: Call<List<RestaurantHeaderModel>>,
                response: Response<List<RestaurantHeaderModel>>
            ) {
//                val code = response.code()
//                if (fail(code)) {
//                    listener.onFailure(failRespose(response.errorBody()!!.string()))
//                } else {
//                    response.body()?.let { listener.onSuccess(i) }
//                }
            }

        })
    }

//    //fun list() = mRemote.list()

}