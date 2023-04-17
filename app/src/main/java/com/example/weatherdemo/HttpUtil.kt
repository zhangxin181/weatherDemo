package com.example.weatherdemo

import okhttp3.OkHttpClient
import org.json.JSONObject
import java.lang.Exception


object HttpUtil {
    const val url =
        "https://restapi.amap.com/v3/weather/weatherInfo?key=ba3e9ad45c8cdbc27930f0161c48dd9e&extensions=all&city="
    val cityCode: List<String> = listOf("110000", "310000", "440100", "440300", "320500", "210100")

    val okHttpClient = OkHttpClient.Builder().build()


    fun jsonToData(json: String): CityWeather? {
        return try {
            val jsonObject = JSONObject(json)
            val jsonArray = jsonObject.getJSONArray("forecasts")
            val jsonObject2 = jsonArray.getJSONObject(0)
            val cityName: String = jsonObject2.getString("city")
            val jsonArray2 = jsonObject2.getJSONArray("casts")
            val jsonObject3 = jsonArray2.getJSONObject(0)
            val dayWeather: String = jsonObject3.getString("dayweather")
            val nightWeather: String = jsonObject3.getString("nightweather")
            val dayTemp: String = jsonObject3.getString("daytemp")
            val nightTemp: String = jsonObject3.getString("nighttemp")
            CityWeather( cityName, dayWeather, nightWeather,dayTemp,nightTemp)
        }catch (e:Exception){
            null
        }
    }
}