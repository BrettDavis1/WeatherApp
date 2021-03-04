package com.example.weather_model.model


import androidx.room.*
import com.example.weather_model.model.Hourly
import com.example.weather_model.model.Daily
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity(
        tableName = "all_weather"
//    tableName = TABLE_NAME,
//    indices = [Index(value = [LAT]), Index(value = [LON])]
)
@JsonClass(generateAdapter = true)
data class AllWeather @JvmOverloads constructor(

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
    val alerts: List<Alert>?) {

    @PrimaryKey(autoGenerate = false)
    var id: Long = 0

}