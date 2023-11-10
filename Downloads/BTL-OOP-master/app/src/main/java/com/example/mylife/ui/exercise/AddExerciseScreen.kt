package com.example.mylife.ui.exercise

import android.widget.Button
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mylife.R
import com.example.mylife.TopBar
import com.example.mylife.navigation.AppScreen
import com.example.mylife.navigation.navigationDestination
import com.example.mylife.reuse.EditNumberField
import com.example.mylife.reuse.EditNumberFieldPass

object AddExerDestination : navigationDestination {
    override val route = "navigateAddExer"
    override val titleRes = R.string.ADDEXER
    const val itemIdArg = "exerId"
    // val routeWithArgs = "$route/{$itemIdArg}"
}
@Composable
fun AddExerciseScreen(navigateToListExer: () -> Unit,
                      navigateToUser: () -> Unit,
                      navigateToHome: () -> Unit,

                      ) {

    var name by remember { mutableStateOf("") }
    var kcal by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize()) {
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
                    text = "Add Exercise",
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
        Image(painter = painterResource(R.drawable.exer), contentDescription = null)
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "Add more exercise:",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
        Column(horizontalAlignment = Alignment.End) {
            Spacer(modifier = Modifier.height(15.dp))
            EditNumberField(
                label = R.string.exer,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                value = name,
                onValueChange = { name = it },
                modifier = Modifier
                    .padding(bottom = 32.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(15.dp))
            EditNumberField(
                label = R.string.kcal,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                value = kcal,
                onValueChange = { kcal = it },
                modifier = Modifier
                    .padding(bottom = 32.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(15.dp))
            Button(onClick = navigateToListExer) {
                Text(text = "ADD")
            }
        }
    }
}

@Composable
fun TestAddExerciseScreen(

                      ) {

    var name by remember { mutableStateOf("") }
    var kcal by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize()) {
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
                    text = "Add Exercise",
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
        Image(painter = painterResource(R.drawable.exer), contentDescription = null)
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "Add more exercise:",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
        Column(horizontalAlignment = Alignment.End) {
            Spacer(modifier = Modifier.height(15.dp))
            EditNumberField(
                label = R.string.exer,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                value = name,
                onValueChange = { name = it },
                modifier = Modifier
                    .padding(bottom = 32.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(15.dp))
            EditNumberField(
                label = R.string.kcal,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                value = kcal,
                onValueChange = { kcal = it },
                modifier = Modifier
                    .padding(bottom = 32.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(15.dp))
            Button(onClick = { }) {
                Text(text = "ADD")
            }
        }
    }
}

@Preview
@Composable
fun preTestAddExerciseScreen() {
    TestAddExerciseScreen()
}