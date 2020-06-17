package com.example.queueup.service.repository.local

import androidx.room.Query
import com.example.queueup.service.model.RestaurantHeaderModel

interface SpecialityDAO {

    @Query("SELECT * FROM tb_restaurante")
    fun all()


    @Query("SELECT type FROM tb_restaurante")
    fun getTypes(): List<RestaurantHeaderModel>
}