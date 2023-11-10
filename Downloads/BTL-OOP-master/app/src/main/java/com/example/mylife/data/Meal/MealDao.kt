package com.example.mylife.data.Meal

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.mylife.data.Serving.Serving
import kotlinx.coroutines.flow.Flow

@Dao
interface MealDao {
    @Insert
    suspend fun insert_meal(meal: Meal)

    @Query("SELECT * FROM Meal WHERE meal_id = :id")
    fun getMeal(id: Int): Flow<Meal>

    @Query("SELECT * FROM MEAL")
    fun getAllMeal(): Flow<List<Meal>>

    @Update
    suspend fun update_meal(meal: Meal)

    @Delete
    suspend fun delte(meal: Meal)

    @Insert
    suspend fun add_serving_to_meal(meal: Meal, serving: Serving)

    @Query("SELECT * FROM serving WHERE serving.meal_id =:id")
    fun getServingFromMeal(id: Int): Flow<List<Serving>>
}