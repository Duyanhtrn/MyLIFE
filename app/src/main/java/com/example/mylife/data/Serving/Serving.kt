package com.example.mylife.data.Serving

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "serving")
data class Serving(
    @PrimaryKey
    val serving_id: Int = 0,
    val meal_id: Int,
    val food_id: Int,
    val amount: Int,
    val serving_calories: Int,
    val serving_protein: Int,
    val serving_carb: Int,
    val serving_fat: Int
    )
