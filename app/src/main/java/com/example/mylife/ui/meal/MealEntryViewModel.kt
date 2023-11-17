package com.example.mylife.ui.meal

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
    savedStateHandle: SavedStateHandle,
    private val mealRepository: MealRepository,
    private val servingRepository: ServingRepository
): ViewModel() {
    private val mealId: Int = checkNotNull(savedStateHandle[AddFoodDestination.mealIdArg])

    private var mealEntryUiState = MutableStateFlow(MealEntryUiState())
    init {
        viewModelScope.launch {
            mealRepository.getServingFromMeal(mealId).collect{
                    servingList -> mealEntryUiState.value = mealEntryUiState.value.copy(servingList = servingList)
            }
            mealEntryUiState.value = mealEntryUiState.value.copy(mealInfo = mealRepository.get_Meal(mealId).first().toMealInfo())
        }
    }
    suspend fun updateUiState(mealNutrition: Nutrition = caculateMealNutrition()){
        mealEntryUiState.value.mealInfo = mealEntryUiState.value.mealInfo.copy(mealNutrition = mealNutrition)
    }
    private fun caculateMealNutrition(uiState: MealEntryUiState = mealEntryUiState.value): Nutrition{
        var protein = 0.0
        var calories = 0.0
        var carb = 0.0
        var fat = 0.0
        for(serving in uiState.servingList){
            calories += serving.serving_calories
            protein += serving.serving_protein
            carb += serving.serving_carb
            fat += serving.serving_fat
        }
        return Nutrition(calories, protein, carb, fat)
    }

    suspend fun updateMeal(){
        mealRepository.update_meal(mealEntryUiState.value.mealInfo.toMeal())
    }

    suspend fun addFood(){
        viewModelScope.launch {
            servingRepository.insertServing(Serving(0,mealId,"",0.0,0.0,0.0,0.0, 0.0))
        }
    }
}

data class MealEntryUiState(
    var servingList: List<Serving> = listOf(),
    var mealInfo: MealInfo = MealInfo()
)
data class MealInfo(
    var mealId: Int = 0,
    var mealNutrition: Nutrition = Nutrition(0.0,0.0,0.0,0.0),
    var creationDate: String? = ""
)
fun MealInfo.toMeal(): Meal = Meal(
    meal_id = mealId,
    meal_protein = mealNutrition.protein,
    meal_calories = mealNutrition.calories,
    meal_carb = mealNutrition.carb,
    meal_fat = mealNutrition.fat,
    creationDate = creationDate
)
fun Meal.toMealInfo(): MealInfo = MealInfo(
    mealId = meal_id,
    mealNutrition = Nutrition(meal_calories, meal_protein, meal_carb, meal_fat),
    creationDate = creationDate
)





