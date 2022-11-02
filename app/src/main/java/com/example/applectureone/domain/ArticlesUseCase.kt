package com.example.applectureone.domain

import android.content.Context
import com.example.applectureone.data.ArticleRepository
import com.example.applectureone.data.model.ArticleEntity
import com.example.applectureone.domain.model.ArticleModel

class ArticlesUseCase(private val context: Context) {

    private val repo = ArticleRepository(context)

    suspend fun getArticles(): List<ArticleModel> {
        val v = repo.getArticles()
        return v.map {
            convertEntityToModel(it)
        }
    }

//    suspend fun getArticleById(id:Long) {
//
//    }

    private fun convertEntityToModel(e: ArticleEntity): ArticleModel {
        return ArticleModel(
            e.id,
            e.title,
            e.description
        )
    }

}