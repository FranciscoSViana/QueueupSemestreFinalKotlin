package com.example.queueup.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.queueup.service.model.RestaurantHeaderModel
import com.example.queueup.service.repository.SpecialityRepository

class UserHomePageViewModel(application: Application) : AndroidViewModel(application) {

    private val mSpecialityRepository = SpecialityRepository(application)

    private val mSpecialityList = MutableLiveData<List<RestaurantHeaderModel>>()
    var specialityList: LiveData<List<RestaurantHeaderModel>> = mSpecialityList

    fun listSpecialities() {
       // mSpecialityList.value = mSpecialityRepository.list()
    }
}