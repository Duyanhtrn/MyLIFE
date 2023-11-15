package com.example.mylife.ui.home


import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mylife.data.Meal.Meal
import com.example.mylife.data.Meal.MealRepository
import com.example.mylife.data.User.User
import com.example.mylife.data.User.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HomeViewModel(
    private val userRepository: UserRepository,
    private val mealRepository: MealRepository
) : ViewModel() {
    private var _homeUiState = MutableStateFlow(HomeUiState(userDetail = UserDetail()))
    val homeUiState = _homeUiState

    init{
        var user = userRepository.getUser(1)
        Log.d("CheckUser", "$user")
        if(user != null){
            _homeUiState.value = _homeUiState.value.copy(userDetail = UserDetail(targetNutrition = Nutrition(user.user_calories, user.user_protein, user.user_carb, user.user_fat)))
        }
        viewModelScope.launch {
            mealRepository.getMealForToday().collect{
                    mealList -> _homeUiState.value = _homeUiState.value.copy(
                mealList = mealList,
                userDetail = _homeUiState.value.userDetail.copy(
                    consumeNutrition = caculateConsume(),
                    remainNutrition = caculateRemain()
                ))
            }

        }
    }
    private fun caculateConsume(mealList: List<Meal> = _homeUiState.value.mealList): Nutrition{
        var calories: Double = 0.0
        var protein: Double = 0.0
        var carb: Double = 0.0
        var fat: Double = 0.0
        for(meal in mealList){
            calories += meal.meal_calories
            protein += meal.meal_protein
            carb += meal.meal_carb
            fat += meal.meal_fat
        }

        return Nutrition(calories,protein,carb,fat)
    }

    private fun caculateRemain(target: Nutrition = _homeUiState.value.userDetail.targetNutrition, consume: Nutrition = _homeUiState.value.userDetail.consumeNutrition ): Nutrition{
        return Nutrition(target.calories-consume.calories, target.protein-consume.protein, target.carb-consume.carb, target.fat-consume.fat)
    }
}

data class HomeUiState(
    var mealList: List<Meal> = listOf(),
    var userDetail: UserDetail = UserDetail()
)

data class UserDetail(
    var targetNutrition:Nutrition = Nutrition(0.0,0.0,0.0,0.0),
    var consumeNutrition:Nutrition = Nutrition(0.0,0.0,0.0,0.0),
    var remainNutrition:Nutrition = Nutrition(0.0,0.0,0.0,0.0),
)

data class Nutrition(
    var calories: Double,
    var protein: Double,
    var carb: Double,
    var fat:Double
)