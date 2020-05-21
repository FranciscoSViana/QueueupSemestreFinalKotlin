package com.example.queueup.service.listener

import com.example.queueup.service.model.HeaderModel

interface APIListener {

    fun onSuccess(model: HeaderModel)
    fun onFailure(str: String)
}