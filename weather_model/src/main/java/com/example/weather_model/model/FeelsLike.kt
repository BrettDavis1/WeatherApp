package com.example.weather_model.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FeelsLike(
    @Json(name = "day")
    val day: Double?,
    @Json(name = "eve")
    val eve: Double?,
    @Json(name = "morn")
    val morn: Double?,
    @Json(name = "night")
    val night: Double?
) {
    constructor() : this(
        0.0, 0.0, 0.0, 0.0
    )
}