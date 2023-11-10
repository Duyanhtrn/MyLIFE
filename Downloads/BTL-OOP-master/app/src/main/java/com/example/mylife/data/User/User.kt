package com.example.mylife.data.User

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mylife.data.Meal.Meal

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = false)
    val user_id: Int,
    val user_name: String,
    val user_gender: String,
    val user_age: Int,
    val user_height: Int,
    val user_weight: Int,
    val user_activity_rate: String,
    val user_aim: String,
    val user_bmi: Double,
    val user_tdee: Double,
    val user_choice: String,
    val user_calories: Double,
    val user_protein: Double,
    val user_carb: Double,
    val user_fat: Double,
)


