package com.example.applectureone.presentation.articles

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applectureone.domain.ArticlesUseCase
import com.example.applectureone.domain.model.ArticleModel
import kotlinx.coroutines.launch

class ArticlesViewModel : ViewModel() {

    val useCase = ArticlesUseCase()

    val isLoading = MutableLiveData<Boolean>()
    val articles = MutableLiveData<List<ArticleModel>>()

    init {
        loadData()
    }

    fun reloadData() {
        loadData()
    }

    private fun loadData() {

        viewModelScope.launch {
            isLoading.postValue(true)

            val v = useCase.getArticles()
            articles.postValue(v)

            isLoading.postValue(false)
        }

    }


}