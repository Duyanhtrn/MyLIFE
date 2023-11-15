package com.example.mylife.ui.food

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mylife.data.Food.Food
import com.example.mylife.data.Food.FoodRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class FoodListViewModel(
    private val foodRepository: FoodRepository
): ViewModel(){
    var foodListUiState: StateFlow<FoodListUiState> =
        foodRepository.getAllFoodStream().map { FoodListUiState(it) }
            .stateIn(
                scope =viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000L),
                initialValue =FoodListUiState()
            )
}
data class FoodListUiState(
    var foodList: List<Food> = listOf()
)
