package com.example.applectureone.domain

import android.content.Context
import androidx.room.Room
import com.example.applectureone.data.ArticleRepository
import com.example.applectureone.data.local.AppDatabase
import com.example.applectureone.data.local.model.UserEntity
import com.example.applectureone.domain.model.UserModel

class UserUseCase(private val context: Context) {

    private val repo = ArticleRepository(context)
    private val db = Room.databaseBuilder(context, AppDatabase::class.java, "db-name").build()
    private val dao = db.userDao()

    fun saveUsername(string: String) {
        repo.setUserName(string)
    }

    fun getUsername(): String {
        return repo.getUserName() ?: ""
    }

    suspend fun saveUserData(data: UserModel) {
        dao.insertAll(
            UserEntity(
                firstName = data.firstName,
                lastName = data.lastName
            )
        )
    }

    suspend fun getUserDataList(): List<UserModel> {
        val list = dao.getAll()
        return list.map {
            UserModel(it.firstName ?: "", it.lastName ?: "")
        }
    }

}