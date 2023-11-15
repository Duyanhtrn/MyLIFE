package com.example.mylife.reuse


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.tooling.preview.Preview


import androidx.compose.ui.unit.dp
import com.example.mylife.ui.home.Nutrition
import com.example.mylife.ui.home.UserDetail

// bảng hiển thị kcal in và out trong 1 ngày
// số kcal chênh lệch nằm trong kcal total

@Composable
fun infIn(nutrition: Nutrition) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Kcal in")
        Text(text = "${nutrition.calories}")
    }
}

@Composable
fun infNeed(nutrition: Nutrition) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Remain")
        Text(text = "${nutrition.calories}")
    }
}

@Composable
fun infDay(nutrition: Nutrition) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Kcal daily")
        Text(text = "${nutrition.calories}")
    }
}

@Composable
fun YourKcal(modifier: Modifier, userDetail: UserDetail) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        infIn(userDetail.consumeNutrition)
        Spacer(modifier = Modifier.width(15.dp))
        infNeed(userDetail.remainNutrition)
        Spacer(modifier = Modifier.width(15.dp))
        infDay(userDetail.targetNutrition)
    }
}

