package com.example.weatherdemo

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherdemo.ui.FutureWeather


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherView(viewModel: MainViewModel) {
    val items: List<CityWeather> by viewModel.stateFlow.collectAsState(listOf())

    LaunchedEffect(key1 = true) {
        viewModel.loadWeather()
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "明天天气") },
            )
        }
    ) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(1f)
        ) {
            items(items) { item ->
                FutureWeather(
                    item.city,
                    item.dayWeather,
                    item.nightWeather,
                    item.dayTemp,
                    item.nightTemp
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

        }
    }
}