package com.example.queueup.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.queueup.service.constants.TaskConstants
import com.example.queueup.service.listener.APIRestaurantListener
import com.example.queueup.service.listener.ValidationListener
import com.example.queueup.service.model.RestaurantHeaderModel
import com.example.queueup.service.repository.RestaurantRepository
import com.example.queueup.service.repository.local.SecurityPreferences

class RegisterRestaurantViewModel(application: Application) : AndroidViewModel(application) {

    private val mRestaurantRepository = RestaurantRepository(application)
    private val mSharedPreferences = SecurityPreferences(application)

    private val mCreate = MutableLiveData<ValidationListener>()
    val create: LiveData<ValidationListener> = mCreate


    fun create(restaurant: RestaurantHeaderModel) {
        mRestaurantRepository.create(restaurant, object : APIRestaurantListener {
            override fun onSuccess(modelRestaurant: RestaurantHeaderModel) {
                modelRestaurant.cnpj?.let {
                    mSharedPreferences.store(
                        TaskConstants.SHAREDRESTAURANT.CNPJ_KEY, it
                    )
                }
                modelRestaurant.password?.let {
                    mSharedPreferences.store(
                        TaskConstants.SHAREDRESTAURANT.PASSWORD_CNPJ, it
                    )
                }
                modelRestaurant.name?.let {
                    mSharedPreferences.store(
                        TaskConstants.SHAREDRESTAURANT.RESTAURANT_NAME,
                        it
                    )
                }

                mCreate.value = ValidationListener()
            }

            override fun onFailure(str: String) {
                mCreate.value = ValidationListener(str)
            }

        })
    }
}