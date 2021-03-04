package com.example.weather_model.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Current(
 @Json(name = "clouds")
   val clouds: Double?,
 @Json(name = "dew_point")
    val dewPoint: Double?,
 @Json(name = "dt")
    val dt: Double?,
 @Json(name = "feels_like")
    val feelsLike: Double?,
 @Json(name = "humidity")
    val humidity: Double?,
 @Json(name = "pressure")
    val pressure: Double?,
 @Json(name = "sunrise")
    val sunrise: Double?,
 @Json(name = "sunset")
    val sunset: Double?,
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
    val windSpeed: Double?) {

    companion object {
        const val TABLE_NAME = "current"
        const val ALL_WEATHER_ID = "allWeatherId"
    }
}