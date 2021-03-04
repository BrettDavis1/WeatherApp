package com.example.weather_model.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Daily(
    @Json(name = "clouds")
    val clouds: Double?,
    @Json(name = "dew_point")
    val dewPoint: Double?,
    @Json(name = "dt")
    val dt: Long?,
    @Json(name = "feels_like")
    val feelsLike: FeelsLike?,
    @Json(name = "humidity")
    val humidity: Double?,
    @Json(name = "pop")
    val pop: Double?,
    @Json(name = "pressure")
    val pressure: Double?,
    @Json(name = "rain")
    val rain: Double?,
    @Json(name = "sunrise")
    val sunrise: Double?,
    @Json(name = "sunset")
    val sunset: Double?,
    @Json(name = "temp")
    val temp: Temp?,
    @Json(name = "uvi")
    val uvi: Double?,
    @Json(name = "weather")
    val weather: List<Weather>?,
    @Json(name = "wind_deg")
    val windDeg: Double?,
    @Json(name = "wind_speed")
    val windSpeed: Double?
) {
    constructor() : this(
        0.0, 0.0,0L,FeelsLike(), 0.0, 0.0, 0.0,0.0,0.0, 0.0,
        Temp(0.0, 0.0, 0.0, 0.0, 0.0, 0.0), 0.0, listOf<Weather>(Weather()), 0.0, 0.0
    )
}