package com.example.weatherapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
//import com.example.weatherapp.model.NameWeather
import com.example.weatherapp.repo.local.WeatherDatabase
//import com.example.weatherapp.repo.local.dao.NameWeatherDao
//
//class NameWeatherViewModel(application: Application) : AndroidViewModel(application) {
//    private val nameWeatherDao: NameWeatherDao = WeatherDatabase.getDatabase(application).nameWeatherDao()
//    val nameWeatherList: LiveData<List<NameWeather>>
//
//    init {
//        nameWeatherList = nameWeatherDao.nameWeather
//    }
//
//    suspend fun insert(vararg nameWeathers: NameWeather) {
//        nameWeatherDao.insert(*nameWeathers)
//    }
//
//    suspend fun update(nameWeather: NameWeather) {
//        nameWeatherDao.update(nameWeather)
//    }
//
//    suspend fun deleteAll() {
//        nameWeatherDao.deleteAll()
//    }
//}