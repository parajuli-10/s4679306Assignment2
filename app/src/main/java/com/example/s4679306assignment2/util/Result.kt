package com.example.s4679306assignment2.util

sealed class Result<out T> {
    object Loading : Result<Nothing>()
    data class Success<T>(val data: T): Result<T>()
    data class Error(val message: String): Result<Nothing>()
}
