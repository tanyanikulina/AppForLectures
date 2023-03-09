package com.example.applectureone.data.remote.model

import com.google.gson.annotations.SerializedName

data class CurrentApiModel(
    @SerializedName("dt") val date: Long?,
    val sunrise: Long?,
    val sunset: Long?,
    val temp: Float?,
    @SerializedName("feels_like") val feelsLike: Float?,
    val pressure: Int?,
    val humidity: Int?,
    @SerializedName("dew_point") val dewPoint: Float?,
    val uvi: Float?,  //Midday UV index
    val clouds: Int?,
    val visibility: Long?, // Average visibility, metres
    @SerializedName("wind_speed") val windSpeed: Float?,
    @SerializedName("wind_deg") val windDegrees: Int?,
    val weather: List<WeatherTypeApiModel>?,
    val rain: SnowRainApiModel?,
    val snow: SnowRainApiModel?,
)