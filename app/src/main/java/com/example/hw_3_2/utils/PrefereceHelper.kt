package com.example.hw_3_2.utils

import android.content.Context
import android.content.SharedPreferences

class PrefereceHelper {


    private lateinit var sharedPreferences: SharedPreferences

    fun unit(context: Context) {
        sharedPreferences = context.getSharedPreferences("shared", Context.MODE_PRIVATE)
    }

//    var text: String?
//        get() = sharedPreferences.getString("text", "")
//        set(value: String?) = sharedPreferences.edit().putString("text", value).apply()

    var isOnBoard: Boolean
        get() = sharedPreferences.getBoolean("isOnBoardingCompleted", false)
        set(value: Boolean) = sharedPreferences.edit().putBoolean("isOnBoardingCompleted", value).apply()
}