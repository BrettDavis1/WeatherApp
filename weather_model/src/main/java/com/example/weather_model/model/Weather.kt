package com.example.weather_model.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Weather(
    @Json(name = "description")
    val description: String?,
    @Json(name = "icon")
    val icon: String?,
    @Json(name = "id")
    val id: Double?,
    @Json(name = "main")
    val main: String?
) {
    constructor() : this(
        "", "", 0.0, ""
    )
}