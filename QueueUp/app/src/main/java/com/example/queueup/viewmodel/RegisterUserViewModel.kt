package com.example.queueup.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.queueup.service.model.PersonHeaderModel
import com.example.queueup.service.constants.TaskConstants
import com.example.queueup.service.listener.APIListener
import com.example.queueup.service.listener.ValidationListener
import com.example.queueup.service.repository.PersonRepository
import com.example.queueup.service.repository.local.SecurityPreferences

class RegisterUserViewModel(application: Application) : AndroidViewModel(application) {

    private val mPersonRepository = PersonRepository(application)
    private val mSharedPreferences = SecurityPreferences(application)

    private val mCreate = MutableLiveData<ValidationListener>()
    val create: LiveData<ValidationListener> = mCreate

    fun create(name: String, cpf: String, password: String) {
        mPersonRepository.create(name, cpf, password, object : APIListener {
            override fun onSuccess(modelPerson: PersonHeaderModel) {

                mSharedPreferences.store(TaskConstants.SHARED.CPF_KEY, modelPerson.cpf)
                mSharedPreferences.store(TaskConstants.SHARED.PASSWORD_KEY, modelPerson.password)
                mSharedPreferences.store(TaskConstants.SHARED.PERSON_NAME, modelPerson.name)

                mCreate.value = ValidationListener()
            }

            override fun onFailure(str: String) {
                mCreate.value = ValidationListener(str)
            }

        })
    }
}