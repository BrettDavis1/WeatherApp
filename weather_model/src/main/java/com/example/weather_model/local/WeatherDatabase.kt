package com.example.weatherapp.repo.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.weather_model.local.Converters
import com.example.weather_model.model.AllWeather
import com.example.weather_model.local.dao.AllWeatherDao
//import com.example.weatherapp.repo.local.dao.NameWeatherDao

//@Database(entities = [NameWeather::class, AllWeather::class], version = 1)
@Database(entities = [AllWeather::class], version = 1)
@TypeConverters(Converters::class)
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun allWeatherDao() : AllWeatherDao
//    abstract fun nameWeatherDao() : NameWeatherDao

    companion object {
        private var INSTANCE : WeatherDatabase? = null
        private const val DB_NAME = "weather.db"

        fun getDatabase(context: Context): WeatherDatabase {
            if(INSTANCE == null) {
                synchronized(WeatherDatabase::class.java) {
                    if(INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,WeatherDatabase::class.java, DB_NAME
                        ).build()
                    }
                }
            }
            return INSTANCE!!
        }
    }
}