package com.example.queueup.service.listener

import com.example.queueup.service.model.RestaurantHeaderModel

interface APIRestaurantListener {

    fun onSuccess(modelRestaurant: RestaurantHeaderModel)
    fun onFailure(str: String)
}