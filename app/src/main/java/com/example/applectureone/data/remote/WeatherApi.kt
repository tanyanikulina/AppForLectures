package com.example.applectureone.data.remote

import com.example.applectureone.data.remote.model.WeatherApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface WeatherApi {

    @GET("onecall")
    suspend fun getWeather(@QueryMap params: Map<String, String>): Response<WeatherApiModel>

}