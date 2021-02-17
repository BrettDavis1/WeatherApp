package com.example.weatherapp.repo

import com.example.weatherapp.model.AllWeather
import com.example.weatherapp.model.NameWeather
import com.example.weatherapp.repo.remote.AllWeatherService
import com.example.weatherapp.repo.remote.RetrofitInstance

object AllWeatherRepo {
    val allWeatherService = RetrofitInstance.allWeatherService

    suspend fun getAllWeather() : AllWeather {
        return RetrofitInstance.allWeatherService.getAllWeather()
    }
    suspend fun getAllWeather(lat: Double, lon: Double) : AllWeather {
        return RetrofitInstance.allWeatherService.getAllWeatherLatLon(lat, lon)
    }
    suspend fun getNameWeather() : NameWeather {
        return RetrofitInstance.allWeatherService.getNameWeather()
    }
}