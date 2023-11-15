package com.example.mylife.data.Serving

import com.example.mylife.data.Food.Food
import kotlinx.coroutines.flow.Flow

interface ServingRepository {
    suspend fun insertServing(serving: Serving)

    suspend fun deleteServing(serving: Serving)

    suspend fun updateServing(serving: Serving)

    fun getServing(id: Int): Flow<Serving>

    fun getAllServing(): Flow<List<Serving>>

    fun getFoodFromServing(id: Int): Flow<Food>

}