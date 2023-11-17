package com.example.mylife.ui.meal

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mylife.data.Food.Food
import com.example.mylife.data.Food.FoodRepository
import com.example.mylife.data.Serving.OfflineServingRepository
import com.example.mylife.data.Serving.Serving
import com.example.mylife.ui.food.DetailUiState
import com.example.mylife.ui.home.Nutrition
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class AddFoodViewModel(
    savedStateHandle: SavedStateHandle,
    private val servingRepository: OfflineServingRepository,
    private val foodRepository: FoodRepository
): ViewModel() {
    private val foodId: Int = 0
    private val servingId: Int = 0

    private var _addFoodUiState = MutableStateFlow(AddFoodUiState())
    val addFoodUiState = _addFoodUiState
    init {
        viewModelScope.launch{
            servingRepository.getServing(servingId).collect{
                serving -> _addFoodUiState.value = serving.toUiState()
            }
            foodRepository.getFoodStream(foodId).collect{
                    food -> _addFoodUiState.value = _addFoodUiState.value.copy(selectedFood = food.toDetailUiState())
            }
            _addFoodUiState.value = addFoodUiState.value.copy(servingNutrition = caculateServingNutrition())
        }
    }
    private fun addFood(){
        viewModelScope.launch {
            servingRepository.insertServing(_addFoodUiState.value.toServing())
        }
    }

    suspend fun updateUiState(quantity: String){
        _addFoodUiState.value = _addFoodUiState.value.copy(quantity = quantity)
    }
    private fun caculateServingNutrition(uiState: AddFoodUiState = _addFoodUiState.value): Nutrition{
        return Nutrition(
            uiState.selectedFood.calories * uiState.quantity.toDouble(),
            uiState.selectedFood.protein * uiState.quantity.toDouble(),
            uiState.selectedFood.carb * uiState.quantity.toDouble(),
            uiState.selectedFood.fat * uiState.quantity.toDouble(),
            )
    }

}


data class AddFoodUiState(
    var servingId: Int = 0,
    var mealId: Int = 0,
    var selectedFood: DetailUiState = DetailUiState(),
    var quantity: String = "",
    var servingNutrition: Nutrition = Nutrition(0.0,0.0,0.0,0.0)
)

fun Food.toDetailUiState(): DetailUiState = DetailUiState(
    foodName = food_name,
    calories = food_calories,
    protein = food_protein,
    carb = food_carb,
    fat = food_fat
)

fun Food.toAddFoodUiState(): AddFoodUiState = AddFoodUiState(
    selectedFood = this.toDetailUiState(),
    quantity = ""
)

fun AddFoodUiState.toServing(): Serving = Serving(
    serving_id = 0,
    meal_id = mealId,
    food_name = this.selectedFood.foodName,
    serving_calories = this.servingNutrition.calories,
    serving_protein = this.servingNutrition.protein,
    serving_carb = this.servingNutrition.carb,
    serving_fat = this.servingNutrition.fat,
    quantity = quantity.toDouble()
)

fun Serving.toUiState(): AddFoodUiState = AddFoodUiState(
    servingId = serving_id,
    mealId = meal_id,
    quantity = quantity.toString(),
    servingNutrition = Nutrition(serving_calories, serving_protein, serving_carb, serving_fat)

)