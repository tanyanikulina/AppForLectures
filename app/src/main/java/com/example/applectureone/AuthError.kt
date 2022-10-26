package com.example.applectureone

sealed class AuthError(val message: String) {
    class LoginError(val msg: String) : AuthError(msg)
    object PasswordError : AuthError("wrong password")
}