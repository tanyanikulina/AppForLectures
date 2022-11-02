package com.example.applectureone.presentation.settings

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applectureone.domain.UserUseCase
import com.example.applectureone.domain.model.UserModel
import kotlinx.coroutines.launch

class SettingsViewModel(private val ctx: Context) : ViewModel() {

    private val useCase = UserUseCase(ctx)
    val userDataList = MutableLiveData<List<UserModel>>()

    fun saveUserName(name: String) {
        useCase.saveUsername(name)
    }

    fun getUserName(): String {
        return useCase.getUsername()
    }

    fun saveToDb(first: String, last: String) {
        viewModelScope.launch {
            useCase.saveUserData(UserModel(first, last))
        }
    }

    fun readFromDb() {
        viewModelScope.launch {
            val v = useCase.getUserDataList()
            userDataList.postValue(v)
        }
    }

}