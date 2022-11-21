package com.example.mywonders.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Wonders::class], version = 2)
abstract class WondersDatabase :RoomDatabase(){

    abstract fun contactDAO(): PostDao
}