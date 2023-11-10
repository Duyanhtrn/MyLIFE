package com.example.mylife.ui.information


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mylife.data.User.User
import com.example.mylife.data.User.UserRepository
import kotlinx.coroutines.launch

class EntryInfoViewModel(
    private val userRepository: UserRepository
) : ViewModel() {
    var entryInfoUiState by mutableStateOf(EntryInfoUiState())
        private set

    //Update Ui State
    fun updateUiState(userInfo: UserInfo){
        entryInfoUiState = EntryInfoUiState(userInfo = userInfo, isEntryValid = validateInput(userInfo))
    }
    suspend fun saveUser(){
        if(validateInput()){
            caculateBMI()
            caculateTDEE()
            userRepository.add_user(entryInfoUiState.userInfo.toUser())
        }
    }
    private fun validateInput(uiState: UserInfo = entryInfoUiState.userInfo): Boolean{
        return with(uiState){
            userName.isNotBlank() && userGender.isNotBlank() && userAge.isNotBlank() && userHeight.isNotBlank()
                    && userWeight.isNotBlank() && userAim.isNotBlank() && userActivityRate.isNotBlank()
        }
    }
    private fun caculateBMI(uiState: UserInfo = entryInfoUiState.userInfo){
        var BMI: Double
        val height: Int = uiState.userHeight.toInt()
        val weight: Int = uiState.userWeight.toInt()
        BMI = (weight/(height*height)).toDouble()

        entryInfoUiState = entryInfoUiState.copy(userInfo = uiState.copy(userBmi = BMI))
    }
    private fun caculateTDEE(uiState: UserInfo = entryInfoUiState.userInfo){
        val height: Int = uiState.userHeight.toInt()
        val weight: Int = uiState.userWeight.toInt()
        val age: Int = uiState.userAge.toInt()
        val gender = if (uiState.userGender == "Male") 5 else -161
        val userActivityRate = when(uiState.userActivityRate){
            "Lightly Active" -> 1.375
            "Moderately Active" -> 1.55
            else -> 1.55
        }
        val tdee = (10 * weight + 6.25 * height - 5 * age + gender) * userActivityRate

        entryInfoUiState = entryInfoUiState.copy(userInfo = uiState.copy(userTdee = tdee.toDouble()))
    }
}
data class EntryInfoUiState(
    val userInfo: UserInfo = UserInfo(),
    val isEntryValid: Boolean = false
)

data class UserInfo(
    val userId: Int = 0,
    val userName: String = "",
    val userGender: String = "",
    val userAge: String = "",
    val userHeight: String = "",
    val userWeight: String = "",
    val userActivityRate: String = "",
    val userBmi: Double = 0.0,
    val userTdee: Double = 0.0,
    val userAim: String = "",
    val userCalories: Double = 0.0,
    val userProtein: Double = 0.0,
    val userCarb: Double = 0.0,
    val userFat: Double = 0.0,
    val userChoice: String = ""
)

fun UserInfo.toUser(): User = User(
    user_id = userId,
    user_name = userName,
    user_age = userAge.toIntOrNull()?: 0,
    user_gender = userGender,
    user_height = userHeight.toIntOrNull()?:0,
    user_weight = userWeight.toIntOrNull()?:0,
    user_activity_rate = userActivityRate,
    user_bmi = userBmi,
    user_tdee = userTdee,
    user_aim = userAim,
    user_calories = userCalories,
    user_protein = userProtein,
    user_carb = userCarb,
    user_fat = userFat,
    user_choice = userChoice
)