package com.example.mylife.ui.information


import android.annotation.SuppressLint
import android.graphics.Paint
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mylife.R
import com.example.mylife.TopBar
import com.example.mylife.navigation.AppScreen
import com.example.mylife.navigation.navigationDestination
import com.example.mylife.ui.AppViewModelProvider

object USerDestination : navigationDestination {
    override val route = "navigateToUser"
    override val titleRes = R.string.USERINFOR
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UserInformationScreen(
    navigateToHome: () -> Unit,
    navigateToEntryInfor: () -> Unit,
    viewModel: UserInformationViewModel = viewModel(factory = AppViewModelProvider.Factory)
){
    Scaffold(
        topBar = {
            TopBar(hasUser = true,
                hasHome = true,
                navigateToHome = navigateToHome)
        },
    ) { innerPadding ->
        UserInformationScreenBody(
            navigateToEntryInfor,
            userInfo = viewModel.userInfomationUiState.value.userInfo
        )
    }
}

@Composable
fun UserInformationScreenBody(navigateToEntryInfor: () -> Unit,
    userInfo: UserInfo
) {
    var gender = if(userInfo.userGender == "1") "Male" else "Female"
    var activityRate = if(userInfo.userActivityRate == "1") "Lightly Activate" else if (userInfo.userActivityRate == "2") "Moderate Activate" else "Very Activate"
    var goal = if(userInfo.userAim == "1") "Keep Weight" else if(userInfo.userAim == "2") "Gain Weight" else "Lose Weight"
    Column(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Image(painter = painterResource(R.drawable.hand), contentDescription = null)
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Name: ${userInfo.userName}",
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Gender: $gender",
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Age: ${userInfo.userAge}",
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Height: ${userInfo.userHeight}",
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Weight: ${userInfo.userWeight}",
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Your Activity Rate: $activityRate ",
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "BMI = ${userInfo.userBmi}, DEE = ${userInfo.userTdee}",
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Goal: $goal",
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(20.dp))

        }
        Column(horizontalAlignment = Alignment.End,
            modifier = Modifier.padding(15.dp).fillMaxWidth()) {
            Button(
                onClick = navigateToEntryInfor,
            ) {
                Text(
                    text = "Update Your Profile",
                    textAlign = TextAlign.End
                )
            }
        }
    }

}

@Composable
fun Test()

                          {
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
                    text = "User Information",
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
        Column(modifier = Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.height(30.dp))
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painter = painterResource(R.drawable.hand), contentDescription = null)
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Name: %s",
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Age: %d",
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Height: %d",
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Weight: %d",
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "BMI = %.2f, DEE %.2f",
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Goal: %s",
                    fontSize = 20.sp
                )
            }
        }
    }
}

@Preview
@Composable
fun PreTest(){
    Test()
}

