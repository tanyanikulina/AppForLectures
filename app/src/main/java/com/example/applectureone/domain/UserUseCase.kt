package com.example.applectureone.domain

import android.content.Context
import com.example.applectureone.data.ArticleRepository

class UserUseCase(private val context: Context) {

    private val repo = ArticleRepository(context)

    fun saveUsername(string: String) {
        repo.setUserName(string)
    }

    fun getUsername(): String {
        return repo.getUserName() ?: ""
    }

}