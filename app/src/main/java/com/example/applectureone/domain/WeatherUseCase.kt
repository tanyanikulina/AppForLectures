package com.example.applectureone.domain

import com.example.applectureone.data.local.model.WeatherEntity
import java.text.SimpleDateFormat
import java.util.*

class WeatherUseCase {

    fun getWeather() {

        // 1. go to inet and get data
        // 2. if(success) {save data to database and return data as WeatherEntity from db }
        // 3. else {return data from db as WeatherEntity}


    }

    private fun mapData(data: WeatherEntity) {

        val timeInMillis = System.currentTimeMillis()
        val date = Date(timeInMillis)
        val str = SimpleDateFormat("dd MM yyyy").format(date)

    }


}