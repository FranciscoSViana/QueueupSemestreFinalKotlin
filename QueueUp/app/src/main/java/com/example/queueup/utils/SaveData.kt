package com.example.queueup.utils

import android.content.Context
import android.content.SharedPreferences

class SaveData(context: Context) {

    private val mPreferences: SharedPreferences =
        context.applicationContext.getSharedPreferences("save", Context.MODE_PRIVATE)

    fun store(value: String) {
        val editor: SharedPreferences.Editor? = mPreferences.edit()
        editor?.putString("default", value)
        editor?.apply()
    }

    fun get(): String? {
        return mPreferences.getString("default", "")
    }
}