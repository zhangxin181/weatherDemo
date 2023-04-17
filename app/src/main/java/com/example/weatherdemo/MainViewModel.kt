package com.example.weatherdemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import okhttp3.Request

class MainViewModel : ViewModel() {

    private val _stateFlow =
        MutableStateFlow(listOf<CityWeather>())
    val stateFlow = _stateFlow.asStateFlow()

    fun loadWeather() {
        val cityWeathers = mutableListOf<CityWeather>()
        viewModelScope.launch(Dispatchers.IO) {
            repeat(6) {
                val job = async {
                    getWeatherByCityCode(HttpUtil.cityCode[it])
                }
                job.await()?.let { it1 -> cityWeathers.add(it1) }
            }
            _stateFlow.value = _stateFlow.value + cityWeathers
        }
    }

    private fun getWeatherByCityCode(cityCode: String): CityWeather? {
        val stringBuffer = StringBuffer(HttpUtil.url).append(cityCode)
        val request = Request.Builder()
            .url(stringBuffer.toString())
            .get()
            .build()
        val call = HttpUtil.okHttpClient.newCall(request)
        val response = call.execute()
        if (response.isSuccessful) {
            return HttpUtil.jsonToData(response.body?.string()!!)
        }else{
            return null
        }
    }
}