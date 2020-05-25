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

class LoginRestViewModel(application: Application) : AndroidViewModel(application) {

    private val mRestaurantRepository = RestaurantRepository(application)
    private val mSharedPreferences = SecurityPreferences(application)

    private val mLoginRest = MutableLiveData<ValidationListener>()
    val loginRest: LiveData<ValidationListener> = mLoginRest

    private val mLoggedRest = MutableLiveData<Boolean>()
    val loggedRest: LiveData<Boolean> = mLoggedRest

    fun doLoginRest(cnpj: String, password: String) {
        mRestaurantRepository.login(cnpj, password, object : APIRestaurantListener {
            override fun onSuccess(modelRestaurant: RestaurantHeaderModel) {
                mSharedPreferences.store(
                    TaskConstants.SHAREDRESTAURANT.CNPJ_KEY,
                    modelRestaurant.cnpj
                )
                mSharedPreferences.store(
                    TaskConstants.SHAREDRESTAURANT.PASSWORD_CNPJ,
                    modelRestaurant.password
                )
                mSharedPreferences.store(
                    TaskConstants.SHAREDRESTAURANT.RESTAURANT_NAME,
                    modelRestaurant.name
                )

                mLoginRest.value = ValidationListener()
            }

            override fun onFailure(str: String) {
                mLoginRest.value = ValidationListener(str)
            }

        })
    }

    fun verifyLoggedRest() {

        val token = mSharedPreferences.get(TaskConstants.SHAREDRESTAURANT.CNPJ_KEY)
        val restaurant = mSharedPreferences.get(TaskConstants.SHAREDRESTAURANT.PASSWORD_CNPJ)

        val logged = (token != "" && restaurant != "")
        mLoggedRest.value = logged
    }
}