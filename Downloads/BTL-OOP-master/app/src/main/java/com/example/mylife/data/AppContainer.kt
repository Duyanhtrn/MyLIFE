package com.example.mylife.data

import android.content.Context
import android.util.Log
import com.example.mylife.data.Food.FoodRepository
import com.example.mylife.data.Food.OfflineFoodRepository
import com.example.mylife.data.Meal.MealRepository
import com.example.mylife.data.Meal.OfflineMealRepository
import com.example.mylife.data.Serving.OfflineServingRepository
import com.example.mylife.data.Serving.Serving
import com.example.mylife.data.Serving.ServingRepository
import com.example.mylife.data.User.OfflineUserRepository
import com.example.mylife.data.User.UserRepository


interface AppContainer {
    val foodRepository: FoodRepository
    val servingRepository: ServingRepository
    val mealRepository: MealRepository
    val userRepository: UserRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val mealRepository: MealRepository by lazy {
        OfflineMealRepository(AppDatabase.getDatabase(context).mealDao())
    }
    override val userRepository: UserRepository by lazy {
        Log.d("AppDataContainer", "UserRepo is initialized")
        OfflineUserRepository(AppDatabase.getDatabase(context).userDao())
    }
    override val foodRepository: FoodRepository by lazy{
        OfflineFoodRepository(AppDatabase.getDatabase(context).foodDao())
    }
    override val servingRepository: ServingRepository by lazy{
        OfflineServingRepository(AppDatabase.getDatabase(context).servingDao())
    }
}