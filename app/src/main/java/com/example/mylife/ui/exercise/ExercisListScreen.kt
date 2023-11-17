package com.example.mylife.ui.exercise

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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mylife.R
import com.example.mylife.TopBar
import com.example.mylife.navigation.AppScreen
import com.example.mylife.navigation.navigationDestination
import com.example.mylife.ui.meal.rowItemFoodMealBody
import java.nio.file.WatchEvent

// chứa thông tin của các hoạt động. VD: chạy: 100kcal mỗi 30p
// có thể thêm hoạt động bằng button +
object ExerListDestination : navigationDestination {
    override val route = "navigateToListExer"
    override val titleRes = R.string.EXERLIST
    const val itemIdArg = "exerId"
    // val routeWithArgs = "$route/{$itemIdArg}"
}
@Composable
fun Item(modifier : Modifier = Modifier,
                    name: String,
                    kcal: Int,
                    time: Int
) {
    Box(modifier=Modifier.border(1.dp, Color.Black)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.exercise),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = name,
                )
            }
            Text(text = "${kcal} Kcal/${time}p")
        }
    }
}

// cho phép cuộn
@Composable
fun MyLazyColum() {
    LazyColumn {
        item {
            Text(text = "List Activity:",
                modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 10.dp),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold)
//            Item(name = "Run", kcal = 100, time= 60)
//            Spacer(modifier = Modifier.height(20.dp))
//            Item(name = "Swim", kcal = 100, time = 20)
//            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun rowItemExercise(navigateToAddExer: () -> Unit,
                    navigateToUser: () -> Unit,
                    navigateToHome: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopBar(

                navigateToHome=navigateToHome,
                navigateToUserInfor = navigateToUser,
                hasHome = true,
                hasUser = true
            )
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = navigateToAddExer,
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            }
        },

        ) { innerPadding ->
        rowItemExerciseBody(

        )
    }
}
@Composable
fun rowItemExerciseBody(


//                    canNavigateBack: Boolean,
//                    navigateUp: () -> Unit = {},
//                    currentScreen: AppScreen
) {
    Column {
        Spacer(modifier = Modifier.height(45.dp))
        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier.padding(20.dp, 0.dp, 20.dp, 0.dp)
        ) {
            Column {
                Spacer(modifier = Modifier.height(20.dp))
                MyLazyColum()
            }

        }
    }
}


