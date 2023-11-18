package com.example.mylife.ui.meal

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mylife.data.Food.Food
import com.example.mylife.data.Meal.Meal
import com.example.mylife.data.Meal.MealRepository
import com.example.mylife.data.Serving.OfflineServingRepository
import com.example.mylife.data.Serving.Serving
import com.example.mylife.data.Serving.ServingRepository
import com.example.mylife.ui.home.Nutrition
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MealEntryViewModel(
    private val mealRepository: MealRepository,
): ViewModel() {
    var mealEntryUiState by mutableStateOf(MealEntryUiState())
        private set

    fun updateUiState(uiState: MealEntryUiState){
        mealEntryUiState = MealEntryUiState(mealName = uiState.mealName)
    }

    suspend fun addMeal(){
        mealRepository.insert_meal(mealEntryUiState.toMeal())
    }
}

data class MealEntryUiState(
    val mealName: String = ""
)

fun MealEntryUiState.toMeal(): Meal = Meal(
    meal_id = 0,
    meal_name = mealName,
    meal_calories = 0.0,
    meal_protein = 0.0,
    meal_carb = 0.0,
    meal_fat = 0.0,
    creationDate = getCurrentDate()
)