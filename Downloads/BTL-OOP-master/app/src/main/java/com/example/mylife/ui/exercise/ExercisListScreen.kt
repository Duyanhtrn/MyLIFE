package com.example.mylife.ui.exercise

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
import com.example.mylife.navigation.AppScreen
import com.example.mylife.navigation.navigationDestination
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
                    kcal: Int
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
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = name,
                )
            }
            Text(text = "${kcal} Kcal/30p")
        }
    }
}

@Composable
fun MyLazyColum() {
    LazyColumn {
        item {
            Item(name = "run", kcal = 100)
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun rowItemExercise(navigateToAddExer: () -> Unit,
                    navigateToUser: () -> Unit,
                    navigateToHome:  () -> Unit,
//                    canNavigateBack: Boolean,
//                    navigateUp: () -> Unit = {},
//                    currentScreen: AppScreen
){
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
                    text = "List Exercise",
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
            Column {
                Spacer(modifier = Modifier.height(20.dp))
                MyLazyColum()
            }
            Button(
                onClick = navigateToAddExer,

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
fun TestrowItemExercise(

){
    Column {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = {  }) {
                    Icon(
                        imageVector = Icons.Filled.Home,
                        contentDescription = null
                    )
                }
                Text(
                    text = "List Exercise",
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
            modifier = Modifier.padding(20.dp, 0.dp, 20.dp, 0.dp)) {
            Column {
                Spacer(modifier = Modifier.height(20.dp))
                Item(name = "run", kcal = 100)
                Spacer(modifier = Modifier.height(15.dp))
                Item(name = "swing", kcal = 200)
                Spacer(modifier = Modifier.height(15.dp))
                Item(name = "jump", kcal = 150)
                Spacer(modifier = Modifier.height(15.dp))
                Item(name = "sleep", kcal = 70)
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
fun preTestrowItemExercise(){
    TestrowItemExercise()
}
