package com.example.applectureone

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserModel(
    val name: String,
    var age: Int? = null,
) : Parcelable {

    val myValue = "hjk,l"

    fun multiply(x: Int, y: Int = 1): Int {

        return x * y

    }


}
