package com.example.applectureone.data.local

import android.content.Context

class SharedPrefs(context: Context) {

    private val prefsName = "my_prefs"
    private val userNameKey = "user_name"
    private val userAgeKey = "user_age"

    private val sharedPreferences = context.getSharedPreferences(prefsName, Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()

    fun getUserAge(): Int {
        return sharedPreferences.getInt(userAgeKey, -1)
    }

    fun setUserAge(age: Int) {
        editor.putInt(userAgeKey, age)
        editor.commit()
    }

    fun getUserName(): String? {
        return sharedPreferences.getString(userNameKey, "")
    }

    fun setUserName(userName: String?) {
        editor.putString(userNameKey, userName)
        editor.commit()
    }

}