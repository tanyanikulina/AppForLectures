package com.example.applectureone.data.remote.model

import com.google.gson.annotations.SerializedName

data class WeatherApiModel(
    val lat: Float?,
    val lon: Float?,
    val timezone: String?,
    @SerializedName("timezone_offset") val timezoneOffset: Long?,
    val current: CurrentApiModel?,
    val hourly: List<HourlyApiModel>?,
    val daily: List<DailyApiModel>?,
)