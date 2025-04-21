package vidu.example.upathiraarachchigemidterm.repostiory

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import vidu.example.upathiraarachchigemidterm.api.WeatherService

class WeatherRepository {

        private val weatherService: WeatherService

        init {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://weather.visualcrossing.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            weatherService = retrofit.create(WeatherService::class.java)
        }

        suspend fun getWeather(city: String) = weatherService.getWeather(city)
    }