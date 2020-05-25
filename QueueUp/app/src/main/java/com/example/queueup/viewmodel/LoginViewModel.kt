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

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val mPersonRepository = PersonRepository(application)
    private val mSharedPreferences = SecurityPreferences(application)

    private val mLogin = MutableLiveData<ValidationListener>()
    val login: LiveData<ValidationListener> = mLogin

    private val mLoggedUser = MutableLiveData<Boolean>()
    val loggedUser: LiveData<Boolean> = mLoggedUser

    fun doLogin(cpf: String, password: String) {
        mPersonRepository.login(cpf, password, object : APIListener {
            override fun onSuccess(modelPerson: PersonHeaderModel) {

                mSharedPreferences.store(TaskConstants.SHARED.CPF_KEY, modelPerson.cpf)
                mSharedPreferences.store(TaskConstants.SHARED.PASSWORD_KEY, modelPerson.password)
                mSharedPreferences.store(TaskConstants.SHARED.PERSON_NAME, modelPerson.name)

                mLogin.value = ValidationListener()
            }

            override fun onFailure(str: String) {
                mLogin.value = ValidationListener(str)
            }

        })
    }

    //Verifica se o usuário está logado
    fun verifyLoggedUser() {

        val token = mSharedPreferences.get(TaskConstants.SHARED.CPF_KEY)
        val person = mSharedPreferences.get(TaskConstants.SHARED.PASSWORD_KEY)

        val logged = (token != "" && person != "")
        mLoggedUser.value = logged
    }

}