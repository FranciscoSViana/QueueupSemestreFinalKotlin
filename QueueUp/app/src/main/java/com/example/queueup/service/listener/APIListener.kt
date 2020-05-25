package com.example.queueup.service.listener

import com.example.queueup.service.model.PersonHeaderModel

interface APIListener {

    fun onSuccess(modelPerson: PersonHeaderModel)
    fun onFailure(str: String)

}