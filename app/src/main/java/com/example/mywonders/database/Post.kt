package com.example.mywonders.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PostTable")
data class Wonders(
    val imageUrl: String,
    @PrimaryKey(autoGenerate = false)
    val name: String,
)
