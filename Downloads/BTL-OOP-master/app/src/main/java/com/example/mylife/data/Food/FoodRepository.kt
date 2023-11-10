package com.example.mylife.data.Food

import kotlinx.coroutines.flow.Flow

interface FoodRepository {
    fun getAllFoodStream(): Flow<List<Food>>

    fun getFoodStream(name: String): Flow<Food>

    suspend fun addFood(food: Food)

    suspend fun updateFood(food: Food)

}