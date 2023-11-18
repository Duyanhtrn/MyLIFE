package com.example.mylife.data.Serving

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "serving")
data class Serving(
    @PrimaryKey
    val serving_id: Int = 0,
    val meal_id: Int,
    val food_name: String,
    val quantity: Double,
    val serving_calories: Double,
    val serving_protein: Double,
    val serving_carb: Double,
    val serving_fat: Double
    )
