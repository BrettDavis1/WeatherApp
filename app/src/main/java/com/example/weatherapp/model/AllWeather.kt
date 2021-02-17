package com.example.weatherapp.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AllWeather(
    @Json(name = "current")
    val current: Current?,
    @Json(name = "daily")
    val daily: List<Daily>?,
    @Json(name = "hourly")
    val hourly: List<Hourly>?,
    @Json(name = "lat")
    val lat: Double?,
    @Json(name = "lon")
    val lon: Double?,
    @Json(name = "timezone")
    val timezone: String?,
    @Json(name = "timezone_offset")
    val timezoneOffset: Double?,
    @Json(name = "alerts")
    val alerts: List<Alert>?
)