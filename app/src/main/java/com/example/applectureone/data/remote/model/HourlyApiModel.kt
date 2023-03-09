package com.example.applectureone.data.remote.model

import com.google.gson.annotations.SerializedName

data class HourlyApiModel(
    @SerializedName("dt") val date: Long?,
    val temp: Float?,
    @SerializedName("feels_like") val feelsLike: Float?,
    val pressure: Int?,
    val humidity: Int?,
    @SerializedName("dew_point") val dewPoint: Float?,
    val clouds: Int?,
    val visibility: Long?,// Average visibility, metres
    @SerializedName("wind_speed") val windSpeed: Float?,
    @SerializedName("wind_deg") val windDegrees: Int?,
    @SerializedName("wind_gust") val windGust: Float?,
    val pop: Float?,
    val weather: List<WeatherTypeApiModel>?,
    val rain: SnowRainApiModel?,
    val snow: SnowRainApiModel?
)