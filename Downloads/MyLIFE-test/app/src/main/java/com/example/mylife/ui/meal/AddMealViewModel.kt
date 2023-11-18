package com.example.mylife.ui.meal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mylife.data.Meal.Meal
import com.example.mylife.data.Meal.MealRepository
import com.example.mylife.ui.home.Nutrition
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class AddMealViewModel(
    private var mealRepository: MealRepository
): ViewModel() {
    val uiState: StateFlow<AddMealUiState> =
        mealRepository.getMealForToday().map{AddMealUiState(mealList = it)}
            .stateIn(
                scope =viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000L),
                initialValue = AddMealUiState()
            )

}
fun getCurrentDate(): String{
    val dateFormat = SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.getDefault())
    return dateFormat.format(Calendar.getInstance().time)
}
data class AddMealUiState(
    var mealList: List<Meal> = listOf(),
)