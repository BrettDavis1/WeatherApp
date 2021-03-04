package com.example.weather_model.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Alert(
    @Json(name = "description")
    val description: String?,
    @Json(name = "end")
    val end: Double?,
    @Json(name = "event")
    val event: String?,
    @Json(name = "sender_name")
    val senderName: String?,
    @Json(name = "start")
    val start: Double?
) {
    constructor() : this(
        "",0.0,"","",0.0
    )
}