package com.example.mylife.data.Activity

import android.service.voice.VoiceInteractionSession.ActivityId
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.mylife.data.Meal.Converters

@Entity(tableName = "user_activity")
data class UserActivity (
    @PrimaryKey(autoGenerate = true)
    var user_activity_id: Int = 0,
    var activity_id: Int,
    var time: Int,
    var calories_consume: Double,
    @TypeConverters(Converters::class)
    var creationDate: String?
)