package com.example.mylife.ui.information


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mylife.R
import com.example.mylife.TopBar
import com.example.mylife.navigation.AppScreen
import com.example.mylife.navigation.navigationDestination

object USerDestination : navigationDestination {
    override val route = "navigateToUser"
    override val titleRes = R.string.USERINFOR
}
@Composable
fun UserInformationScreen(navigateToHome: () -> Unit,

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

