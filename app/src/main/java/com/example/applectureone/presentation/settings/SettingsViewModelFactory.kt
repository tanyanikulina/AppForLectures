package com.example.applectureone.presentation.settings

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SettingsViewModelFactory(private val ctx: Context) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {
            SettingsViewModel::class.java -> SettingsViewModel(ctx) as T
            else -> super.create(modelClass)
        }
    }

}