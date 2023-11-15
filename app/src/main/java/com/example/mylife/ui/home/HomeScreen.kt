package com.example.mylife.ui.home


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.filled.Home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mylife.R
import com.example.mylife.TopBar
import com.example.mylife.navigation.navigationDestination
import com.example.mylife.reuse.YourKcal

import com.example.mylife.ui.information.USerDestination
import androidx.navigation.NavController
import com.example.mylife.reuse.KcalDay
import com.example.mylife.ui.AppViewModelProvider
import com.example.mylife.ui.information.UpProfileBody
import com.example.mylife.ui.information.UserInfo

object HomeDestination : navigationDestination {
    override val route = "navigateToHome"
    override val titleRes = R.string.HOME
}

@Composable
fun Food(navigateToListFood: () -> Unit,){
    Box(modifier = Modifier
        .padding(20.dp, 20.dp, 20.dp, 0.dp)
        .border(1.dp, Color.Black)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                Image(
                    painter = painterResource(R.drawable.food),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(
                        text = stringResource(R.string.food),

                        )
                    Text(
                        text = "Daily Goal",

                        )
                }
            }
            Button(
                onClick = navigateToListFood,

                ) {
                Text(text = "View")
            }
        }
    }
}

@Composable
fun Exer(navigateToListExer: () -> Unit,){
    Box(modifier = Modifier
        .padding(20.dp, 20.dp, 20.dp, 0.dp)
        .border(1.dp, Color.Black)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                Image(
                    painter = painterResource(R.drawable.exercise),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(
                        text = stringResource(R.string.exercise),

                        )
                    Text(
                        text = "Daily Goal",

                        )
                }
            }
            Button(
                onClick =  navigateToListExer ,

                ) {
                Text(text = "View")
            }
        }
    }
}

@Composable
fun Meal(navigateToListMeal: () -> Unit,){
    Box(modifier = Modifier
        .padding(20.dp, 20.dp, 20.dp, 0.dp)
        .border(1.dp, Color.Black)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                Image(
                    painter = painterResource(R.drawable.brunch),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(
                        text = stringResource(R.string.Meal),

                        )
                    Text(
                        text = "Meal Daily",

                        )
                }
            }
            Button(
                onClick =  navigateToListMeal ,

                ) {
                Text(text = "View")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navigateToListFood: () -> Unit,
    navigateToListExer: () -> Unit,
    navigateToUser: () -> Unit,
    navigateToListMeal: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val homeUiState by viewModel.homeUiState.collectAsState()
    Scaffold(
        topBar = {
            TopBar(hasUser = true,
                navigateToUserInfor = navigateToUser,
                hasHome = true)
        },
    ) { innerPadding ->
        HomeScreenBody(
            navigateToListFood,
            navigateToListExer,
            navigateToListMeal,
            userDetail = homeUiState.userDetail
        )
    }
}

// trang chính của app
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreenBody(
               navigateToListFood: () -> Unit,
               navigateToListExer: () -> Unit,
               navigateToListMeal: () -> Unit,
               modifier: Modifier = Modifier,
               userDetail: UserDetail
        ) {
    Column {

        Spacer(modifier = Modifier.height(45.dp))
        Column {
            Spacer(modifier = Modifier.height(30.dp))
            YourKcal(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center),
                userDetail = userDetail
            )
            Spacer(modifier = Modifier.height(15.dp))
            KcalDay(nutrition = userDetail.targetNutrition)
            KcalDay(nutrition = userDetail.consumeNutrition)
            Spacer(modifier = Modifier.height(30.dp))
            Food(navigateToListFood)
            Exer(navigateToListExer)
            Meal(navigateToListMeal)
        }
    }
    }

