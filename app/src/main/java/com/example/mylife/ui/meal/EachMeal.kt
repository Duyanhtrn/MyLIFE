package com.example.mylife.ui.meal

import android.annotation.SuppressLint
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mylife.R
import com.example.mylife.TopBar
import com.example.mylife.navigation.navigationDestination
import com.example.mylife.reuse.KcalDay
import com.example.mylife.reuse.YourKcal
import com.example.mylife.ui.home.Nutrition
import com.example.mylife.ui.home.UserDetail
import java.nio.file.WatchEvent

// trang chứa thông tin của tất cả các food có trong CSDL và có thể thêm bằng dấu cộng.
// trang chứa thông tin như carot 100kcal/100g
// có button + để có thể thêm loại đồ ăn mình muốn

object EachMealDestination : navigationDestination {
    override val route = "navigateToEachMeal"
    override val titleRes = R.string.MEALLIST
    // const val itemIdArg = "foodId"
    // val routeWithArgs = "$route/{$itemIdArg}"
}

// từng phần tử
@Composable
fun Item(name: String,
         kcal: Int,
         navigateToDetailFood: () -> Unit
       ){
    Box(modifier = Modifier.padding(20.dp, 0.dp, 20.dp, 0.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.Black)
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.food),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column() {
                    Text(
                        text = name,
                    )
                    Text(text = "At 9:AM")
                }
            }
            Button(onClick = navigateToDetailFood) {
                Text(text = "Detail")
            }
        }
    }
}

// hàm cho phép cuộn khi có quá nhiều phần tử
@Composable
fun MyLazyColumnMeal(navigateToDetailFood: () -> Unit) {
    Column {
        Spacer(modifier = Modifier.height(45.dp))
        Text(text = "Foods in Meal:",
            modifier = Modifier.padding(23.dp, 25.dp, 23.dp, 10.dp),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold)
        YourKcal(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center),
            userDetail = UserDetail()
        )
        Spacer(modifier = Modifier.height(15.dp))
        KcalDay(Nutrition(0.0,0.0,0.0,0.0))
        LazyColumn() {
            item {

                Spacer(modifier = Modifier.height(15.dp))
                Item(name = "Susu", kcal = 100,navigateToDetailFood)
                Spacer(modifier = Modifier.height(14.dp))
                Item(name = "Susu", kcal = 100, navigateToDetailFood)
                Spacer(modifier = Modifier.height(14.dp))

            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun rowItemEachMeal(navigateToAddFood: () -> Unit,
                    navigateToUser: () -> Unit,
                    navigateToHome: () -> Unit,
                    navigateToDetailFood: () -> Unit
)
{
    Scaffold(
        topBar = {
            TopBar(

                navigateToHome,
                navigateToUser,
                hasHome = true,
                hasUser = true
            )
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = navigateToAddFood,
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            }
        },

        ) { innerPadding ->
        rowItemFoodMealBody(
            navigateToDetailFood
        )
    }
}

@Composable
fun rowItemFoodMealBody(navigateToDetailFood: () -> Unit

) {
    Column() {

        Column(
        ) {
            MyLazyColumnMeal(navigateToDetailFood)
        }
    }
}



@Composable
fun TestEachmeal(
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
fun TestEachMeal(){
   // MyLazyColumn()
}

