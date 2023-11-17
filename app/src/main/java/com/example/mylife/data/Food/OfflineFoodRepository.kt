package com.example.mylife.data.Food

import kotlinx.coroutines.flow.Flow

class OfflineFoodRepository(private val foodDao: FoodDao) : FoodRepository {
    override suspend fun addFood(food: Food) = foodDao.addFood(food)

    override fun getAllFoodStream(): Flow<List<Food>> = foodDao.getAllFood()

    override fun getFoodStream(id: Int): Flow<Food> = foodDao.getFood(id)

    override suspend fun updateFood(food: Food) = foodDao.updateFood(food)

    override fun searchFood(s: String): Flow<List<Food>> = foodDao.searchFood(s)
}