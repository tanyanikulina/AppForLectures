package com.example.applectureone.data.local

import android.content.Context

class SharedPrefs(context: Context) {

    private val prefsName = "my_prefs"
    private val userNameKey = "user_name"

    private val sharedPreferences = context.getSharedPreferences(prefsName, Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()

    fun getUserName(): String? = sharedPreferences.getString(userNameKey, "")

    fun setUserName(userName: String?) {
        editor.apply {
            putString(userNameKey, userName)
            commit()
        }
    }

}