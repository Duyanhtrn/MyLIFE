package com.example.mylife.data.Serving

import com.example.mylife.data.Food.Food
import kotlinx.coroutines.flow.Flow

class OfflineServingRepository(private var servingDao: ServingDao): ServingRepository {
    override suspend fun insertServing(serving: Serving) = servingDao.insert_serving(serving)

    override suspend fun deleteServing(serving: Serving) = servingDao.delete_serving(serving)

    override suspend fun updateServing(serving: Serving) = servingDao.update_serving(serving)

    override fun getAllServing(): Flow<List<Serving>> = servingDao.get_all_serving()

    override fun getServing(id: Int): Flow<Serving> = servingDao.get_serving(id)

    override fun getFoodFromServing(id: Int): Flow<Food> = servingDao.get_food_from_serving(id)
}