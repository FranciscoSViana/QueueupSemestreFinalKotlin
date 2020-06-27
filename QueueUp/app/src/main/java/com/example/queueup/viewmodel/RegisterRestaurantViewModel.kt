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
        mRestaurantRepository.create(
            restaurant,
            object : APIRestaurantListener<Any?> {
                override fun onSuccess(modelRestaurant: RestaurantHeaderModel) {
                    modelRestaurant.idRestaurante?.let {
                        mSharedPreferences.store(
                            TaskConstants.SHAREDRESTAURANT.ID_RESTAURANTE,
                            it
                        )
                    }

                    modelRestaurant.name?.let {
                        mSharedPreferences.store(
                            TaskConstants.SHAREDRESTAURANT.RESTAURANT_NAME,
                            it
                        )
                    }
                    modelRestaurant.cnpj?.let {
                        mSharedPreferences.store(
                            TaskConstants.SHAREDRESTAURANT.CNPJ_KEY,
                            it
                        )
                    }
                    modelRestaurant.city?.let {
                        mSharedPreferences.store(
                            TaskConstants.SHAREDRESTAURANT.RESTAURANT_CITY,
                            it
                        )
                    }
                    modelRestaurant.state?.let {
                        mSharedPreferences.store(
                            TaskConstants.SHAREDRESTAURANT.RESTAURANT_STATE,
                            it
                        )
                    }
                    modelRestaurant.district?.let {
                        mSharedPreferences.store(
                            TaskConstants.SHAREDRESTAURANT.RESTAURANT_DISTRICT,
                            it
                        )
                    }
                    modelRestaurant.street?.let {
                        mSharedPreferences.store(
                            TaskConstants.SHAREDRESTAURANT.RESTAURANT_STREET,
                            it
                        )
                    }
                    modelRestaurant.number?.let {
                        mSharedPreferences.store(
                            TaskConstants.SHAREDRESTAURANT.RESTAURANT_NUMBER,
                            it
                        )
                    }
                    modelRestaurant.cep?.let {
                        mSharedPreferences.store(
                            TaskConstants.SHAREDRESTAURANT.RESTAURANT_CEP,
                            it
                        )
                    }
                    modelRestaurant.telephone?.let {
                        mSharedPreferences.store(
                            TaskConstants.SHAREDRESTAURANT.RESTAURANT_TELEPHONE,
                            it
                        )
                    }
                    modelRestaurant.password?.let {
                        mSharedPreferences.store(
                            TaskConstants.SHAREDRESTAURANT.PASSWORD_CNPJ,
                            it
                        )
                    }
                    modelRestaurant.type?.let {
                        mSharedPreferences.store(
                            TaskConstants.SHAREDRESTAURANT.RESTAURANT_TYPE,
                            it
                        )
                    }
//                    modelRestaurant.capacity?.let {
//                        mSharedPreferences.store(
//                            TaskConstants.SHAREDRESTAURANT.RESTAURANT_CAPACITY,
//                            it.toString()
//                        )
//                    }
                    mCreate.value = ValidationListener()
                }

                override fun onFailure(str: String) {
                    mCreate.value = ValidationListener(str)
                }

            })
    }
}