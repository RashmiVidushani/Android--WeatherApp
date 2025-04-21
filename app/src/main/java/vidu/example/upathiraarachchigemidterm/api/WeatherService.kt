package vidu.example.upathiraarachchigemidterm.api

import retrofit2.http.GET
import retrofit2.http.Path
import vidu.example.upathiraarachchigemidterm.model.WeatherData

interface WeatherService {
    @GET("VisualCrossingWebServices/rest/services/timeline/{city}?unitGroup=metric&key=XKM2VASAHPG73EY759T8KBRSD&contentType=json")
    suspend fun getWeather(@Path("city") city: String): WeatherData
}