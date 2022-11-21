package com.example.mywonders.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PostDao {

    @Insert
    suspend fun insert(user: Wonders)


    @Delete
    suspend fun delete(user: Wonders)

    @Query("delete from PostTable")
    suspend fun deleteAll()

    @Query("SELECT * FROM PostTable")
     fun getdata():LiveData<List<Wonders>>

     @Query("Select * from PostTable where name=:name")
     fun getPostData(name:String):LiveData<Wonders>
}