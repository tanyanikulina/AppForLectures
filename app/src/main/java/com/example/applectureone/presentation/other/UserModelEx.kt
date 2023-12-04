package com.example.applectureone.presentation.other

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserModelEx(
    val name: String,
    var age: Int? = null,
) : Parcelable {

    val myValue = "hjk,l"

    fun multiply(x: Int, y: Int = 1): Int {

        return x * y

    }


}


@Parcelize
data class Cat(
    val name: String,
    var age: Int? = null,
) : Parcelable