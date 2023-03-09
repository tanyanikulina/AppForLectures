package com.example.applectureone.data

import com.example.applectureone.data.remote.ApiFactory
import com.example.applectureone.data.remote.Result
import com.example.applectureone.data.remote.model.WeatherApiModel
import retrofit2.Response
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class WeatherRepository {

    private val api = ApiFactory.weatherApi
    private val API_KEY = "7d31fa3d928db13433eed3fa0aef859a"


    suspend fun getWeather(lat: String = "48.0", lon: String = "35.0"): WeatherApiModel? {

        val params = HashMap<String, String>()
        params.put("lat", lat)
        params.put("lon", lon)
        params.put("appid", API_KEY)
        params.put("units", "metric")
        params.put("exclude", "minutely")

        val resp = safetyCall { api.getWeather(params) }

        return when (resp) {
            is Result.Success -> resp.data
            else -> null
        }

    }

    private suspend fun <T> safetyCall(call: suspend () -> Response<T>): Result<T> {
        val response: Result<T>
        try {
            val result = call.invoke()
            response = if (result.isSuccessful) {
                Result.Success(result.body()!!)
            } else {
                Result.Error(result.code(), result.toString())
            }
            return response
        } catch (e: Exception) {
            return when (e) {
                is SocketTimeoutException -> Result.ErrorTimeOut
                is UnknownHostException -> Result.ErrorUnknown
//                is JsonDataException -> response = Result.Error(ERROR_JSON_PARSE, e.message ?: "")
                else -> Result.ErrorUnknown
            }
        }
    }


}