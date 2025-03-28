package com.example.hw_3_2

import android.app.Application
import com.example.hw_3_2.utils.PrefereceHelper

class App:Application(){
    override fun onCreate() {
        super.onCreate()
            val shared=PrefereceHelper()
            shared.unit(this)

    }

}