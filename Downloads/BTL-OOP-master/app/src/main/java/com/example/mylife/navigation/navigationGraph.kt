package com.example.mylife.navigation

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.mylife.R
import com.example.mylife.ui.exercise.AddExerDestination
import com.example.mylife.ui.exercise.AddExerciseScreen
import com.example.mylife.ui.exercise.ExerListDestination
import com.example.mylife.ui.exercise.rowItemExercise
import com.example.mylife.ui.meal.AddFoodDestination
import com.example.mylife.ui.meal.AddFoodScreen
import com.example.mylife.ui.food.DetailInforDestination
import com.example.mylife.ui.food.FoodListDestination
import com.example.mylife.ui.food.FullInforFood
import com.example.mylife.ui.food.rowItemFood
import com.example.mylife.ui.home.HomeDestination
import com.example.mylife.ui.home.HomeScreen
import com.example.mylife.ui.information.EntryInforDestination
import com.example.mylife.ui.information.USerDestination
import com.example.mylife.ui.information.UpProfile
import com.example.mylife.ui.information.UserInformationScreen
import com.example.mylife.ui.meal.MealListDestination
import com.example.mylife.ui.meal.rowItemFoodMeal
import com.example.mylife.ui.welcome.WelcomeDestination
import com.example.mylife.ui.welcome.WelcomeScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = WelcomeDestination.route,
        modifier = modifier
    ) {
        composable(route = WelcomeDestination.route) {
            WelcomeScreen(navigateToEntryInfor={ navController.navigate(EntryInforDestination.route) },
                )
        }
        composable(route = EntryInforDestination.route) {
            UpProfile( { navController.navigate(HomeDestination.route) } ,
                )
        }
        composable(route = HomeDestination.route) {
            HomeScreen(navigateToListFood = { navController.navigate(FoodListDestination.route) }
                    , navigateToListExer = { navController.navigate(ExerListDestination.route) },
                navigateToUser = { navController.navigate(USerDestination.route) },
                navigateToListMeal = { navController.navigate(MealListDestination.route) })
        }
        composable(route = FoodListDestination.route) {
            rowItemFood(
                        navigateToDetailFood = { navController.navigate(DetailInforDestination.route) },
                        navigateToUser = { navController.navigate(USerDestination.route) },
                 navigateToHome = { navController.navigate(HomeDestination.route) },
                )
        }
        composable(route = ExerListDestination.route) {
            rowItemExercise(navigateToAddExer = { navController.navigate(AddExerDestination.route) },
                navigateToUser = { navController.navigate(USerDestination.route) },
                navigateToHome = { navController.navigate(HomeDestination.route) },

                )
        }
        composable(route = DetailInforDestination.route) {
            FullInforFood( { navController.navigate(HomeDestination.route) },
                navigateToUser = { navController.navigate(USerDestination.route) },
                navigateToHome = { navController.navigate(HomeDestination.route) },

                )
        }
        composable(route = AddFoodDestination.route) {
            AddFoodScreen(navigateToListMeal = { navController.navigate(MealListDestination.route) },
                navigateToUser = { navController.navigate(USerDestination.route) },
                navigateToHome = { navController.navigate(HomeDestination.route) },
               )
        }
        composable(route = AddExerDestination.route) {
            AddExerciseScreen( { navController.navigate(ExerListDestination.route) },
                navigateToUser = { navController.navigate(USerDestination.route) },
                navigateToHome = { navController.navigate(HomeDestination.route) },
                )
        }
        composable(route = USerDestination.route) {
            UserInformationScreen(navigateToHome = { navController.navigate(HomeDestination.route) },
                )
        }
        composable(route = MealListDestination.route) {
            rowItemFoodMeal(navigateToAddFood = { navController.navigate(AddFoodDestination.route) },
                navigateToDetailFood = { navController.navigate(DetailInforDestination.route) },
                navigateToUser = { navController.navigate(USerDestination.route) },
                navigateToHome = { navController.navigate(HomeDestination.route) },)

        }
    }
}

enum class AppScreen(@StringRes val title: Int) {
    Home(title = R.string.app_name),
    ListFood(title = R.string.FOODLIST),
    ListExer(title = R.string.EXERLIST),
    AddFood(title = R.string.ADDFOOD),
    AddExer(title = R.string.ADDEXER),
    Detail(title = R.string.DETAILINFOR),
    User(title = R.string.USERINFOR),
}