package com.example.weatherdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels

import androidx.compose.runtime.Composable

import androidx.compose.ui.tooling.preview.Preview
import com.example.weatherdemo.ui.FutureWeather
import com.example.weatherdemo.ui.theme.WeatherDemoTheme


class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherView(viewModel)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WeatherDemoTheme {
//        WeatherView()
        FutureWeather()
    }
}