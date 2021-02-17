package com.example.weatherapp.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Sys(
    @Json(name = "country")
    val country: String?,
    @Json(name = "id")
    val id: Double?,
    @Json(name = "sunrise")
    val sunrise: Double?,
    @Json(name = "sunset")
    val sunset: Double?,
    @Json(name = "type")
    val type: Double?
)