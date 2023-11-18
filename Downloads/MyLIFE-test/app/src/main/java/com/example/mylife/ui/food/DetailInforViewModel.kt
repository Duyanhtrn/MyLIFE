package com.example.mylife.ui.food

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mylife.data.Food.FoodRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import java.nio.DoubleBuffer

class DetailInforViewModel(
    savedStateHandle: SavedStateHandle,
    private val foodRepository: FoodRepository
): ViewModel(){
    private var foodId: Int = checkNotNull(savedStateHandle[DetailInforDestination.itemIdArg])

    val uiState: StateFlow<DetailUiState> = foodRepository.getFoodStream(foodId)
        .filterNotNull()
        .map {
            DetailUiState(foodName = it.food_name, calories = it.food_calories, protein = it.food_protein, carb = it.food_carb, fat = it.food_fat)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_00L),
            initialValue =DetailUiState()
        )
}

data class DetailUiState(
    var foodName: String = "",
    var calories: Double = 0.0,
    var protein: Double = 0.0,
    var carb: Double = 0.0,
    var fat: Double = 0.0
)