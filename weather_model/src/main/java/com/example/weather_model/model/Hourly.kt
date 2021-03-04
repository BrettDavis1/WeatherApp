package com.example.weather_model.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Hourly(
    @Json(name = "clouds")
    val clouds: Double?,
    @Json(name = "dew_point")
    val dewPoint: Double?,
    @Json(name = "dt")
    val dt: Long?,
    @Json(name = "feels_like")
    val feelsLike: Double?,
    @Json(name = "humidity")
    val humidity: Double?,
    @Json(name = "pop")
    val pop: Double?,
    @Json(name = "pressure")
    val pressure: Double?,
    @Json(name = "rain")
    val rain: Rain?,
    @Json(name = "temp")
    val temp: Double?,
    @Json(name = "uvi")
    val uvi: Double?,
    @Json(name = "visibility")
    val visibility: Double?,
    @Json(name = "weather")
    val weather: List<Weather>?,
    @Json(name = "wind_deg")
    val windDeg: Double?,
    @Json(name = "wind_speed")
    val windSpeed: Double?
) {
    constructor() :this (
        0.0, 0.0, 0L, 0.0, 0.0, 0.0, 0.0, Rain(0.0), 0.0,
       0.0, 0.0, listOf<Weather>(Weather()),0.0,0.0
    )
}