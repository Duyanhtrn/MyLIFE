package com.example.mylife.data.Food

import kotlinx.coroutines.flow.Flow

class OfflineFoodRepository(private val foodDao: FoodDao) : FoodRepository {
    override suspend fun addFood(food: Food) = foodDao.addFood(food)

    override fun getAllFoodStream(): Flow<List<Food>> = foodDao.getAllFood()

    override fun getFoodStream(name: String): Flow<Food> = foodDao.getFood(name)

    override suspend fun updateFood(food: Food) = foodDao.updateFood(food)
}