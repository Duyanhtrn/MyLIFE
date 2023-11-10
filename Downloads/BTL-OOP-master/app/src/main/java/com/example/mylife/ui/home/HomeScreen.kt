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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mylife.R
import com.example.mylife.TopBar
import com.example.mylife.navigation.navigationDestination
import com.example.mylife.reuse.YourKcal

import com.example.mylife.ui.information.USerDestination
import androidx.navigation.NavController

object HomeDestination : navigationDestination {
    override val route = "navigateToHome"
    override val titleRes = R.string.HOME
}
// trang chính của app
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
               navigateToListFood: () -> Unit,
               navigateToListExer: () -> Unit,
               navigateToUser: () -> Unit,
               navigateToListMeal: () -> Unit,
                modifier: Modifier = Modifier,
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
                    text = "MyLife",
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
        Column {
            Spacer(modifier = Modifier.height(15.dp))
            YourKcal(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center)
            )
            Spacer(modifier = Modifier.height(15.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "Protein: 1g")
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(text = "Carbohydrate: 1g")
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(text = "Fat: 1g")
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(text = "Hydrat: 1g")
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
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
    }
    }

@Composable
fun TestHome(
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
                    text = "MyLife",
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
        Column {
            Column(modifier = Modifier
                .padding(13.dp)
                ) {
                YourKcal(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize(Alignment.Center)
                )
                Spacer(modifier = Modifier.height(15.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize(Alignment.Center)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(text = "Protein: 1g")
                        Spacer(modifier = Modifier.width(15.dp))
                        Text(text = "Carbohydrate: 1g")
                        Spacer(modifier = Modifier.width(15.dp))
                        Text(text = "Fat: 1g")
                        Spacer(modifier = Modifier.width(15.dp))
                        Text(text = "Hydrat: 1g")
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Box(modifier = Modifier
                .padding(20.dp, 20.dp, 20.dp, 0.dp)
                .border(1.dp, Color.Black)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row() {
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
                        onClick = {  },

                        ) {
                        Text(text = "View")
                    }
                }
            }
            Box(modifier = Modifier
                .padding(20.dp, 20.dp, 20.dp, 0.dp)
                .border(1.dp, Color.Black)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
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
                        onClick = {  } ,

                        ) {
                        Text(text = "View")
                    }
                }
            }
            Box(modifier = Modifier
                .padding(20.dp, 20.dp, 20.dp, 0.dp)
                .border(1.dp, Color.Black)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
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
                        onClick = { } ,

                        ) {
                        Text(text = "View")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreTestHome() {
    TestHome()
}
