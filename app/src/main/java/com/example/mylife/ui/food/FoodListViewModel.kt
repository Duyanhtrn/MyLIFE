package com.example.mylife.ui.food

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mylife.data.Food.Food
import com.example.mylife.data.Food.FoodRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class FoodListViewModel(
    private val foodRepository: FoodRepository,
    savedStateHandle: SavedStateHandle
): ViewModel(){
    private var _foodListUiState = MutableStateFlow(FoodListUiState())
    val foodListUiState = _foodListUiState

    private val searchQuery: String = ""
    init {
        viewModelScope.launch {
            foodRepository.searchFood(searchQuery).collect{
                _foodListUiState.value = _foodListUiState.value.copy(searchQuery,it)
            }
        }
    }

    suspend fun updateUiState(uiState: FoodListUiState){
        _foodListUiState.value = _foodListUiState.value.copy(uiState.searchQuery)
    }
}
data class FoodListUiState(
    val searchQuery: String = "",
    val foodList: List<Food> = listOf()
)
