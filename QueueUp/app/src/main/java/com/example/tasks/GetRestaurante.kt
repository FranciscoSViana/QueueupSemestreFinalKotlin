package com.example.tasks

import android.os.AsyncTask
import com.example.queueup.adapters.Restaurante
import com.example.queueup.service.model.RestaurantHeaderModel

class GetRestaurante : AsyncTask<String, Void, com.example.queueup.service.model.Restaurante>() {
    override fun doInBackground(vararg params: String?): com.example.queueup.service.model.Restaurante {
        return Restaurante.criar().getRestaurant(params[0]!!)
    }


}