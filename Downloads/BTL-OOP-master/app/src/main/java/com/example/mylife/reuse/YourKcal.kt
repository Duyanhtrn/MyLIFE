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

// bảng hiển thị kcal in và out trong 1 ngày
// số kcal chênh lệch nằm trong kcal total

@Composable
fun infIn() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Kcal in")
        Text(text = "0")
    }
}

@Composable
fun infNeed() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Result")
        Text(text = "in - day")
    }
}

@Composable
fun infDay() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Kcal daily")
        Text(text = "TDEE +-= 500")
    }
}

@Composable
fun YourKcal(modifier: Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        infIn()
        Spacer(modifier = Modifier.width(15.dp))
        infNeed()
        Spacer(modifier = Modifier.width(15.dp))
        infDay()
    }
}

