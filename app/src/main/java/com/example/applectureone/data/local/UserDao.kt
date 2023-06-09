package com.example.applectureone.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.applectureone.data.local.model.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM UserEntity")
    suspend fun getAll(): List<UserEntity>

    @Query("SELECT * FROM UserEntity WHERE id IN (:userIds)")
    suspend fun loadAllByIds(userIds: IntArray): List<UserEntity>

    @Query(
        "SELECT * FROM UserEntity WHERE first_name LIKE :first AND last_name LIKE :last LIMIT 1"
    )
    suspend fun findByName(first: String, last: String): UserEntity

    @Query("SELECT * FROM UserEntity WHERE id LIKE :userId LIMIT 1")
    suspend fun findUserById(userId: Int): UserEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg users: UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Delete
    suspend fun delete(user: UserEntity)
}