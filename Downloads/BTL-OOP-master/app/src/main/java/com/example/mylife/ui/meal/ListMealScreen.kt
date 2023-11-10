package com.example.mylife.ui.meal

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mylife.R
import com.example.mylife.TopBar
import com.example.mylife.navigation.navigationDestination

// trang chứa thông tin của tất cả các food có trong CSDL và có thể thêm bằng dấu cộng.
// trang chứa thông tin như carot 100kcal/100g
// có button + để có thể thêm loại đồ ăn mình muốn

object MealListDestination : navigationDestination {
    override val route = "navigateToListMeal"
    override val titleRes = R.string.MEALLIST
   // const val itemIdArg = "foodId"
    // val routeWithArgs = "$route/{$itemIdArg}"
}

@Composable
fun Item(name: String,
         kcal: Int,
         navigateToDetailFood: () -> Unit,){
    Row(modifier = Modifier
        .fillMaxWidth()
        .border(1.dp, Color.Black)
        .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,

        ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(R.drawable.food),
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(5.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = name,
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "${kcal} Kcal/100g")
            }
        }
        Button(onClick =navigateToDetailFood) {
            Text(text = "Detail")
        }
    }
    Spacer(modifier = Modifier.height(20.dp))
}

@Composable
fun MyLazyColumn(navigateToDetailFood: () -> Unit) {
    LazyColumn {
        item {
            com.example.mylife.ui.food.Item(name = "Susu", kcal = 100, navigateToDetailFood)
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun rowItemFoodMeal(navigateToAddFood: () -> Unit,
                navigateToDetailFood: () -> Unit,
                navigateToUser: () -> Unit,
                navigateToHome: () -> Unit,
//                canNavigateBack: Boolean,
//                navigateUp: () -> Unit = {},
//                currentScreen: AppScreen
) {
    Column {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = navigateToHome) {
                    Icon(
                        imageVector = Icons.Filled.Home,
                        contentDescription = null
                    )
                }
                Text(
                    text = "List Meal",
                    fontSize = 30.sp,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                IconButton(onClick = navigateToUser) {
                    Icon(
                        imageVector = Icons.Filled.AccountCircle,
                        contentDescription = null
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(horizontalAlignment = Alignment.End,

                    modifier = Modifier.padding(20.dp, 0.dp, 20.dp, 0.dp)) {
            Column() {
                MyLazyColumn(navigateToDetailFood)


            }
            Button(
                onClick = navigateToAddFood,

                ) {
                Image(
                    painter = painterResource(R.drawable.plus),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)

                )
            }
        }
        }
    }


@Composable
fun TestListMeal(
) {
    Column {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Filled.Home,
                        contentDescription = null
                    )
                }
                Text(
                    text = "List Meal",
                    fontSize = 30.sp,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                IconButton(onClick = {  }) {
                    Icon(
                        imageVector = Icons.Filled.AccountCircle,
                        contentDescription = null
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(horizontalAlignment = Alignment.End,

           modifier = Modifier.padding(20.dp, 0.dp, 20.dp, 0.dp)
        ) {
            Column() {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color.Black)
                    .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,

                    ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(painter = painterResource(R.drawable.food),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "Carot",
                            )
                            Text(text = "100 Kcal/100g")
                        }
                    }
                    Button(onClick = {  }) {
                        Text(text ="Detail")
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
            Button(
                onClick = {  },

                ) {
                Image(
                    painter = painterResource(R.drawable.plus),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)

                )
            }
        }
    }
}

@Preview
@Composable
fun PreTestListMeal(){
    TestListMeal()
}

