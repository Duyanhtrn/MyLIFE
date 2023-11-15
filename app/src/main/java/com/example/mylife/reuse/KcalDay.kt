package com.example.mylife.reuse

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mylife.ui.home.Nutrition

@Composable
fun KcalDay(
    nutrition: Nutrition
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Protein: ${nutrition.protein}")
            Spacer(modifier = Modifier.width(15.dp))
            Text(text = "Carbohydrate: ${nutrition.carb}")
            Spacer(modifier = Modifier.width(15.dp) )
            Text(text = "Fat: ${nutrition.fat}")
        }
    }
}