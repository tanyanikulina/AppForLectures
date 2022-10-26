package com.example.applectureone.domain

import com.example.applectureone.data.ArticleRepository
import com.example.applectureone.data.model.ArticleEntity
import com.example.applectureone.domain.model.ArticleModel

class ArticlesUseCase {

    private val repo = ArticleRepository()

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