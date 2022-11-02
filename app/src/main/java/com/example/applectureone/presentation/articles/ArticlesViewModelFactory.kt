package com.example.applectureone.presentation.articles

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ArticlesViewModelFactory(private val ctx: Context) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {
            ArticlesViewModel::class.java -> ArticlesViewModel(ctx) as T
            else -> super.create(modelClass)
        }
    }


}