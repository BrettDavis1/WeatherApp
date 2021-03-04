package com.example.weather_model.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"

    private val client = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        .let {
            OkHttpClient.Builder().addInterceptor(it).build()
        }
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .client(client)
        .build()
    val allWeatherService: AllWeatherService by lazy {
        retrofit.create(AllWeatherService::class.java)
    }
}