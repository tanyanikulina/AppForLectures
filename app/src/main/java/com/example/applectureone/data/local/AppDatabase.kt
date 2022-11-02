package com.example.applectureone.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.applectureone.data.local.model.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}