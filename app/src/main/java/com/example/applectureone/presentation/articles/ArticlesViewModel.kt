package com.example.applectureone.presentation.articles

import android.content.Context
import android.text.format.DateFormat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applectureone.data.WeatherRepository
import com.example.applectureone.domain.ArticlesUseCase
import com.example.applectureone.domain.model.ArticleModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

class ArticlesViewModel(private val ctx: Context) : ViewModel() {

    private val useCase = ArticlesUseCase(ctx)
    private val weatherRepo = WeatherRepository()

    val isLoading = MutableLiveData<Boolean>()
    val articles = MutableLiveData<List<ArticleModel>>()
    val weather = MutableLiveData<String>()

    init {
        loadData()
    }

    fun reloadData() {
        loadData()
    }

    private fun loadData() {

        viewModelScope.launch {
            isLoading.postValue(true)

//            val v = useCase.getArticles()
//            articles.postValue(v)

            val w = weatherRepo.getWeather()
            if (w != null) {
                val current = w.current?.temp
                val date = DateFormat.format("yyyy-MM-dd hh:mm:ss", Date())
                val str = "temp: $current °, time: $date"
                weather.postValue(str)
            } else {
                weather.postValue("no weather")
            }
            isLoading.postValue(false)
            delay(5000)
        }

    }


}