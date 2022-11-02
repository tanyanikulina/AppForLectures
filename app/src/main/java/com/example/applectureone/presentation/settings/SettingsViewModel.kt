package com.example.applectureone.presentation.settings

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.applectureone.domain.UserUseCase

class SettingsViewModel(private val ctx: Context) : ViewModel() {

    private val useCase = UserUseCase(ctx)

    fun saveUserName(name: String) {
        useCase.saveUsername(name)
    }

    fun getUserName(): String {
        return useCase.getUsername()
    }


}