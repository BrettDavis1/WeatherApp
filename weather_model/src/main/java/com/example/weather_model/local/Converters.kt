package com.example.weather_model.local

import androidx.room.TypeConverter
import com.example.weather_model.model.Alert
import com.example.weather_model.model.Current
import com.example.weather_model.model.Daily
import com.example.weather_model.model.Hourly
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class Converters {
    val hourType = Types.newParameterizedType(List::class.java, Hourly::class.java)
    val dailyType = Types.newParameterizedType(List::class.java, Daily::class.java)
    val alertType = Types.newParameterizedType(List::class.java, Alert::class.java)
    @TypeConverter
    fun hourlyWeatherToString(hourly: List<Hourly>): String {
        val adapter = Moshi.Builder().build().adapter<List<Hourly>>(hourType)
        return adapter.toJson(hourly)
    }
    @TypeConverter
    fun stringToHourlyWeather(jsonString: String) : List<Hourly> {
        val adapter = Moshi.Builder().build().adapter<List<Hourly>>(hourType)
        return adapter.fromJson(jsonString) ?: emptyList()
    }
    @TypeConverter
    fun dailyWeatherToString(daily: List<Daily>): String {
        val adapter = Moshi.Builder().build().adapter<List<Daily>>(dailyType)
        return adapter.toJson(daily)
    }
    @TypeConverter
    fun stringToDailyWeather(jsonString: String) : List<Daily> {
        val adapter = Moshi.Builder().build().adapter<List<Daily>>(dailyType)
        return adapter.fromJson(jsonString) ?: emptyList()
    }
    @TypeConverter
    fun alertToString(alert: List<Alert>?): String {
        val adapter = Moshi.Builder().build().adapter<List<Alert>>(alertType)
        return adapter.toJson(alert ?: emptyList())
    }
    @TypeConverter
    fun stringToAlert(jsonString: String) : List<Alert> {
        val adapter = Moshi.Builder().build().adapter<List<Alert>>(alertType)
        return adapter.fromJson(jsonString) ?: emptyList()
    }
    @TypeConverter
    fun currentToString(current: Current): String {
        val adapter = Moshi.Builder().build().adapter(Current::class.java)
        return adapter.toJson(current)
    }
    @TypeConverter
    fun stringToCurrent(jsonString: String) : Current? {
        val adapter = Moshi.Builder().build().adapter(Current::class.java)
        return adapter.fromJson(jsonString)
    }
}