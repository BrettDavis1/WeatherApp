package com.example.weather_model.model


import com.example.weather_model.model.Clouds
import com.example.weather_model.model.Coord
import com.example.weather_model.model.Sys
//import com.example.weatherapp.model.NameWeather.Companion.TABLE_NAME
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NameWeather(
    @Json(name = "base")
        val base: String?,
    @Json(name = "clouds")
        val clouds: Clouds?,
    @Json(name = "cod")
        val cod: Double?,
    @Json(name = "coord")
        val coord: Coord?,
    @Json(name = "dt")
        val dt: Double?,
    @Json(name = "id")
        val id: Double?,
    @Json(name = "main")
        val main: Main?,
    @Json(name = "name")
        val name: String?,
    @Json(name = "sys")
        val sys: Sys?,
    @Json(name = "timezone")
        val timezone: Double?,
    @Json(name = "visibility")
        val visibility: Double?,
    @Json(name = "weather")
        val weather: List<Weather>?,
    @Json(name = "wind")
        val wind: Wind?
)
//@Entity(
//        tableName = TABLE_NAME
//)
//@JsonClass(generateAdapter = true)
//data class NameWeather(
//        @Json(name = "base")
//        @Ignore val base: String?,
//        @Json(name = "clouds")
//        @Ignore val clouds: Clouds?,
//        @Json(name = "cod")
//        @Ignore val cod: Double?,
//        @Json(name = "coord")
////    @ColumnInfo(name = "coord")
//        @Ignore val coord: Coord?,
//        @Json(name = "dt")
//        @ColumnInfo(name = "dt") val dt: Double?,
//        @PrimaryKey(autoGenerate = true)
//        @Json(name = "id")
//        @ColumnInfo(name = "id") val id: Double?,
//        @Json(name = "main")
////    @ColumnInfo(name = "main")
//        @Ignore val main: Main?,
//        @Json(name = "name")
//        @ColumnInfo(name = "name") val name: String?,
//        @Json(name = "sys")
//        @Ignore val sys: Sys?,
//        @Json(name = "timezone")
//        @Ignore val timezone: Double?,
//        @Json(name = "visibility")
//        @Ignore val visibility: Double?,
//        @Json(name = "weather")
////    @ColumnInfo(name = "weather")
//        @Ignore val weather: List<Weather>?,
//        @Json(name = "wind")
//        @Ignore val wind: Wind?) {
//
//    constructor() : this("", Clouds(0.0), 0.0, Coord(0.0, 0.0),
//            0.0, 0.0, Main(0.0, 0.0, 0.0, 0.0, 0.0, 0.0),
//            "", Sys("", 0.0, 0.0, 0.0, 0.0),
//            0.0, 0.0, listOf<Weather>(Weather()),
//            Wind(0.0, 0.0))
//
//    constructor(name: String) : this("", Clouds(0.0), 0.0, Coord(0.0, 0.0),
//            0.0, 0.0, Main(0.0, 0.0, 0.0, 0.0, 0.0, 0.0),
//            name, Sys("", 0.0, 0.0, 0.0, 0.0),
//            0.0, 0.0, listOf<Weather>(Weather()),
//            Wind(0.0, 0.0))
//
//    companion object {
//        const val TABLE_NAME = "name_weather"
//    }
//}