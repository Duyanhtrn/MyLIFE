package com.example.mylife.ui.exercise

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mylife.data.Activity.Activity
import com.example.mylife.data.Activity.OfflineUserActivityRepository
import com.example.mylife.data.Activity.UserActivity
import com.example.mylife.data.Activity.UserActivityRepository
import com.example.mylife.ui.meal.getCurrentDate
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class ExerciseListViewModel(
    private val userActivityRepository: UserActivityRepository,

): ViewModel(){
    var exerciseListUiState: StateFlow<ExerciseListUiState> = userActivityRepository.getActivityForToday()
        .map { ExerciseListUiState(it) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_00L),
            initialValue = ExerciseListUiState()
        )
    suspend fun addActivity(){
        userActivityRepository.addActivity(UserActivity(0,0,0,0.0, getCurrentDate()))
    }
}
data class ExerciseListUiState(
    val exerciseList: List<UserActivity> = listOf()
)