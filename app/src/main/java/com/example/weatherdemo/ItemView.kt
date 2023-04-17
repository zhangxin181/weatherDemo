package com.example.weatherdemo.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun FutureWeather(
    cityName: String = "城市",
    dayWeather: String = "天气",
    nightWeather: String = "天气",
    dayTemp: String = "0",
    nightTemp: String = "0"
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(10.dp)
            .background(shape = RoundedCornerShape(8.dp), color = Color.LightGray)
            .fillMaxWidth(1f)
            .wrapContentHeight()
    ) {
        Text(text = cityName, modifier = Modifier.padding(top = 5.dp))
        Text(text = "${dayTemp}℃~${nightTemp}℃")
        Text(text = "$dayWeather 转 $nightWeather", modifier = Modifier.padding(bottom = 5.dp))
    }
}
