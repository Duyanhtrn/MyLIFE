package com.example.mylife.ui.exercise

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mylife.data.Activity.Activity
import com.example.mylife.data.Activity.ActivityRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class SearchExercise(
    private val exerciseRepository: ActivityRepository,
    savedStateHandle: SavedStateHandle
): ViewModel() {
    private val  searchQuery: String = ""
    private var _searchExercise = MutableStateFlow(SearchExerciseUiState())
    val searchExercise = _searchExercise
    init {
        viewModelScope.launch {
            exerciseRepository.searchForActivity(searchQuery).collect{
                _searchExercise.value = _searchExercise.value.copy(searchQuery,it)
            }
        }
    }

    suspend fun updateUiState(uiState: SearchExerciseUiState = _searchExercise.value){
        _searchExercise.value = _searchExercise.value.copy(uiState.searchQuery)
    }


}

data class SearchExerciseUiState(
    val searchQuery: String = "",
    val exerciseList: List<Activity> = listOf()
)