package com.example.mylife.ui.home


import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import com.example.mylife.data.Meal.Meal
import com.example.mylife.data.Meal.MealRepository
import com.example.mylife.data.User.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(
    private val userRepository: UserRepository,
    private val mealRepository: MealRepository
) : ViewModel() {
    val _homeUiState: StateFlow<HomeUiState>
        get() {
            TODO()
        }
}

data class HomeUiState(
    var mealList: List<Meal>,
    var userDeta: UserDetail = UserDetail()
)

data class UserDetail(
    var targetCalories: Int = 0,
    var targetProtein: Int = 0,
    var targetCarb: Int = 0,
    var targetFat: Int = 0,

    var consumeCalories: Int = 0,
    var consumeProtein: Int = 0,
    var consumeCarb: Int = 0,
    var consumeFat: Int = 0,
)
