package com.example.applectureone.data.local.model

data class ArticleEntity(
    val id: Long,
    val title: String,
    val description: String,
    val imgUrl: String? = null,
    val createdAt: Long? = null,
    val editedAt: Long? = null,
)