package com.example.mylife.data.Food

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food")
data class Food(
    @PrimaryKey
    val food_name: String,
    val food_calories: Double,
    val food_protein: Double,
    val food_carb: Double,
    val food_fat: Double,
)
