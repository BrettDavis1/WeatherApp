package com.example.weather_model

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.example.weather_model.local.dao.AllWeatherDao
import com.example.weather_model.model.AllWeather
import com.example.weather_model.model.NameWeather
import com.example.weather_model.remote.AllWeatherService
import com.example.weatherapp.repo.local.WeatherDatabase
import java.util.*
import javax.inject.Inject

class AllWeatherRepoHilt @Inject constructor(
    private val allWeatherService: AllWeatherService,
//    private val allWeatherDao: AllWeatherDao,
    private val pref: SharedPreferences
) {
    companion object {
    private const val TAG = "AllWeatherRepo"
    const val TIMESTAMP_PREF = "TIMESTAMP_PREF"
    private const val TIMESTAMP_KEY = "TIMESTAMP_KEY"
}


    suspend fun getAllWeather(): AllWeather {
        return allWeatherService.getAllWeather()
    }

    suspend fun getAllWeather(lat: Double, lon: Double): AllWeather {
        return allWeatherService.getAllWeatherLatLon(lat, lon)
    }

    suspend fun getAllWeather(context: Context, lat: Double, lon: Double): AllWeather {
        Log.d(TAG, "get all weather enter")

//        val pref = context.getSharedPreferences(TIMESTAMP_PREF, Context.MODE_PRIVATE)
        val savedTime = pref.getLong(TIMESTAMP_KEY, 0)
        Log.d(TAG, "getAllWeather: savedTime $savedTime")
        val currentTime = Calendar.getInstance()
        Log.d(TAG, "getAllWeather: currentTime $currentTime")

        val savedTimeCalendar = Calendar.getInstance().apply {
            timeInMillis = savedTime
            add(Calendar.MINUTE, 1)
        }
        // Fetch from server
        val allWeatherDao = WeatherDatabase.getDatabase(context).allWeatherDao()
        if (currentTime.time > savedTimeCalendar.time) {
            Log.d(TAG, "getAllWeather: 1 minute has passed")
            pref.edit().putLong(TIMESTAMP_KEY, currentTime.timeInMillis).apply()
            val allWeatherResponse =
                allWeatherService.getAllWeatherLatLon(lat, lon)
            //add fetched data to database
            Log.d(TAG, "fetch from server $allWeatherResponse")
            allWeatherDao.setAllWeather(allWeatherResponse)
            return allWeatherResponse
        }
        //fetch from database
        val weatherFromDb = allWeatherDao.findAllWeather()
        Log.d(TAG, "fetch from database $weatherFromDb")
        return weatherFromDb
    }

    suspend fun getNameWeather(): NameWeather {
        return allWeatherService.getNameWeather()
    }
}