package com.example.weather_model.remote

import com.example.weather_model.BuildConfig
import com.example.weather_model.model.AllWeather
import com.example.weather_model.model.NameWeather
import retrofit2.http.GET
import retrofit2.http.Query

interface AllWeatherService {
    @GET("onecall?lat=31.936&lon=-81.9285&exclude=minutely&appid=${BuildConfig.API_KEY}&units=imperial")
    suspend fun getAllWeather(): AllWeather

    @GET("onecall")
    suspend fun getAllWeatherLatLon(@Query("lat") lat: Double, @Query("lon") lon: Double,
                                    @Query("exclude") exclude: String = "minutely",
                                    @Query("appid") appid: String = BuildConfig.API_KEY,
                                    @Query("units") units: String = "imperial"): AllWeather

    @GET("weather?q=Glennville,Georgia&appid=${BuildConfig.API_KEY}&units=imperial")
    suspend fun getNameWeather() : NameWeather
}