package com.example.weatherapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.weather_model.local.dao.AllWeatherDao
import com.example.weather_model.model.AllWeather
import com.example.weatherapp.repo.local.WeatherDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*
import kotlin.concurrent.fixedRateTimer
import kotlin.concurrent.thread

class AllWeatherViewModel(application: Application) : AndroidViewModel(application) {
    private val allWeatherDao: AllWeatherDao = WeatherDatabase.getDatabase(application).allWeatherDao()

    val allWeatherList: LiveData<List<AllWeather>>

    init {
        allWeatherList = allWeatherDao.allWeather

    }
    suspend fun insert(vararg allWeathers: AllWeather) {
        allWeatherDao.insert(*allWeathers)
    }
    suspend fun update(allWeather: AllWeather) {
        allWeatherDao.update(allWeather)
    }
    suspend fun deleteAll() {
        allWeatherDao.deleteAll()
    }
}