package com.example.applectureone.data.remote.model

import com.google.gson.annotations.SerializedName

data class DailyApiModel(
    @SerializedName("dt") val date: Long?,
    val sunrise: Long?,
    val sunset: Long?,
    val temp: TempApiModel?,
    @SerializedName("feels_like") val feelsLike: TempApiModel?,
    val pressure: Int?,
    val humidity: Int?,
    @SerializedName("dew_point") val dewPoint: Float?,
    @SerializedName("wind_speed") val windSpeed: Float?,
    @SerializedName("wind_gust") val windGust: Float?,
    @SerializedName("wind_deg") val windDegrees: Int?,
    val uvi: Float?,  //Midday UV index
    val clouds: Int?,
    val pop: Int?,
    val visibility: Long?, // Average visibility, metres
    val weather: List<WeatherTypeApiModel>?,
    val rain: SnowRainApiModel?,
    val snow: SnowRainApiModel?,
)