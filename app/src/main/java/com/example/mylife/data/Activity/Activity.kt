package com.example.mylife.data.Activity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "activity")
data class Activity(
    @PrimaryKey
    var activity_name: String,
    var calories_consume: Double,
)
