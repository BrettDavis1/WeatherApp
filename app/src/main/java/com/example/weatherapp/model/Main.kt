package com.example.weatherapp.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Main(
    @Json(name = "feels_like")
    val feelsLike: Double?,
    @Json(name = "humidity")
    val humidity: Double?,
    @Json(name = "pressure")
    val pressure: Double?,
    @Json(name = "temp")
    val temp: Double?,
    @Json(name = "temp_max")
    val tempMax: Double?,
    @Json(name = "temp_min")
    val tempMin: Double?
)