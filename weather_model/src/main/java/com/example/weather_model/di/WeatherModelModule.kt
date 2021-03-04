package com.example.weather_model.di

import android.content.Context
import androidx.room.Room
import com.example.weather_model.AllWeatherRepoHilt
import com.example.weatherapp.repo.local.WeatherDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WeatherModelModule {

    private const val DB_NAME = "weather.db"

    @Provides
    @Singleton
    fun provideWeatherDb(@ApplicationContext context: Context) = Room.databaseBuilder(
        context.applicationContext,WeatherDatabase::class.java, DB_NAME
    ).build()

    @Provides
    @Singleton
    fun provideSharedPref(@ApplicationContext context: Context) = context.getSharedPreferences(
        AllWeatherRepoHilt.TIMESTAMP_PREF, Context.MODE_PRIVATE)
}