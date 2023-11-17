package com.example.mylife.ui.exercise

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mylife.data.Activity.ActivityRepository
import com.example.mylife.data.Activity.UserActivity
import com.example.mylife.data.Activity.UserActivityRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class AddExerciseViewModel(
    private val userActivityRepository: UserActivityRepository,
    private val activityRepository: ActivityRepository,
    savedStateHandle: SavedStateHandle
): ViewModel(){
    private var _addExerciseUiState = MutableStateFlow(AddExerciseUiState())
    val addExerciseUiState = _addExerciseUiState

    private val userActivityId: Int = 0
    init{
        viewModelScope.launch {
            userActivityRepository.getActivity(userActivityId).collect{
                _addExerciseUiState.value = it.toUiState()
            }
            activityRepository.getActivity(_addExerciseUiState.value.selectedActivityId).collect{
                _addExerciseUiState.value = _addExerciseUiState.value.copy(selectedActivity = it.activity_name, activityCalories = it.calories_consume)
            }
        }
    }

    suspend fun updateUiState(addExerciseUiState: AddExerciseUiState){
        _addExerciseUiState.value = _addExerciseUiState.value.copy(
            addExerciseUiState.userActivityId,
            addExerciseUiState.selectedActivityId,
            addExerciseUiState.selectedActivity,
            addExerciseUiState.time,
            caculateCalories(),
            addExerciseUiState.creation
        )
    }
    private fun caculateCalories(uiState: AddExerciseUiState = _addExerciseUiState.value):Double{
        return uiState.activityCalories/30 * uiState.time
    }

    suspend fun saveUserActivity(uiState: AddExerciseUiState = _addExerciseUiState.value){
        userActivityRepository.updateActivity(uiState.toUserActivity())
    }
}

data class AddExerciseUiState(
    val userActivityId: Int = 0,
    val selectedActivityId: Int = 0,
    val selectedActivity: String = "",
    val time: Int = 0,
    val calories: Double = 0.0,
    val creation: String? = "",
    val activityCalories: Double = 0.0,
    )

fun UserActivity.toUiState(): AddExerciseUiState = AddExerciseUiState(
    userActivityId = user_activity_id,
    selectedActivityId = activity_id,
    time = time,
    calories = calories_consume,
    creation = creationDate
)

fun AddExerciseUiState.toUserActivity(): UserActivity = UserActivity(
    user_activity_id = userActivityId,
    activity_id = selectedActivityId,
    time = time,
    calories_consume = calories,
    creationDate = creation,
)