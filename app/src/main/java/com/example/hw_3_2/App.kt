package com.example.hw_3_2

import android.app.Application
import androidx.room.Room
import com.example.hw_3_2.data.db.AppDataBase
import com.example.hw_3_2.utils.PrefereceHelper

class App:Application(){

    companion object{
        var appDataBase: AppDataBase? = null
    }
    override fun onCreate() {
        super.onCreate()
            val shared=PrefereceHelper()
            shared.unit(this)
        getInstance()
    }

    private fun getInstance(): AppDataBase? {
        if (appDataBase == null) {
            appDataBase = applicationContext?.let { context ->
                Room.databaseBuilder(
                    context,
                    AppDataBase::class.java,
                    "note.database"
                ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
            }
        }
        return appDataBase
    }

}