package com.example.hw_3_2.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hw_3_2.data.db.dao.Dao
import com.example.hw_3_2.data.models.NoteModel


@Database(entities=[NoteModel::class],version=1)
abstract class AppDataBase : RoomDatabase(){
    abstract fun noteDao(): Dao
}