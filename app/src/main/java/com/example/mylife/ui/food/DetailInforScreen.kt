package com.example.mylife.ui.food

import android.annotation.SuppressLint
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mylife.R
import com.example.mylife.TopBar
import com.example.mylife.navigation.navigationDestination
import com.example.mylife.ui.AppViewModelProvider
import com.example.mylife.ui.home.HomeDestination
import com.example.mylife.ui.home.HomeScreenBody

//  hiển thị tất cả thông tin về food như đạm, xơ, vitamin, ...

object DetailInforDestination : navigationDestination {
    override val route = "item_details"
    override val titleRes = R.string.DETAILINFOR
    const val itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"
}

@Composable
fun Item(name: String,
         g: Int,
         k: Int =0,
         modifier: Modifier= Modifier
             .border(1.dp, Color.Black)
             .padding(20.dp)
    ) {
    Box(modifier= Modifier
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center)) {
        Row(
            modifier = Modifier
                .border(1.dp, Color.Black)
                .padding(10.dp)
                .width(250.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = name)
            if(g != 0) Text(text = "${g} gam")
            else Text(text = "${k} Kcal")
        }
    }
}

@Composable
fun listItem(
    foodInfo: DetailUiState
){
    Column() {
        Spacer(modifier = Modifier.height(10.dp))
        Item(name = "Kcal: ${foodInfo.calories}", g = 0, 100)
        Spacer(modifier = Modifier.height(15.dp))
        Item(name = "Protein: ${foodInfo.protein}", g = 10)
        Spacer(modifier = Modifier.height(15.dp))
        Item(name = "Carbohydrate: ${foodInfo.carb}", g = 10)
        Spacer(modifier = Modifier.height(15.dp))
        Item(name = "Fat: ${foodInfo.fat}", g = 10)
        }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FullInforFood(
    navigateToUser: () -> Unit,
    navigateToHome: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            TopBar(hasUser = true,
                navigateToUserInfor = navigateToUser,
                navigateToHome = navigateToHome,
                hasHome = true)
        },
    ) { innerPadding ->
        FullInforFoodBody(
        )
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FullInforFoodBody(

//    canNavigateBack: Boolean,
//    navigateUp: () -> Unit = {},
//    currentScreen: AppScreen
    viewModel: DetailInforViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    var uiState = viewModel.uiState.collectAsState()
    Column {
        Spacer(modifier = Modifier.height(45.dp))
        Image(painter = painterResource(R.drawable.detail), contentDescription = null)
        Spacer(modifier = Modifier.height(15.dp))
        Text(text = "Name: ${uiState.value.foodName}",
            modifier=Modifier.padding(20.dp),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        listItem(foodInfo = uiState.value)
    }
    }

@Composable
fun TestFullInforFood(


) {
    Column {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.Home,
                        contentDescription = null
                    )
                }
                Text(
                    text = "Food Nutrition",
                    fontSize = 30.sp,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.AccountCircle,
                        contentDescription = null
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Name/100g:",

            modifier=Modifier.padding(20.dp),
            fontSize = 20.sp,
            )
        Spacer(modifier = Modifier.height(10.dp))
        Column() {
            Spacer(modifier = Modifier.height(10.dp))
            Item(name = "Kcal: ", g = 0, 100)
            Spacer(modifier = Modifier.height(15.dp))
            Item(name = "Protein: ", g = 10)
            Spacer(modifier = Modifier.height(15.dp))
            Item(name = "Carbohydrate: ", g = 10)
            Spacer(modifier = Modifier.height(15.dp))
            Item(name = "Fat: ", g = 10)
            Spacer(modifier = Modifier.height(15.dp))
            Item(name = "Vitamin: ", g = 10)
            Spacer(modifier = Modifier.height(15.dp))
            Item(name = "Hydrat: ", g = 10)
        }
    }
}

@Preview
@Composable
fun preTestFullInforFood(){
    TestFullInforFood()
}
