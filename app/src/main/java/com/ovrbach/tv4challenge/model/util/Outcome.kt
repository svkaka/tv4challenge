package com.ovrbach.tv4challenge.model.util

sealed class Outcome<out T : Any?> {
    data class Success<out T : Any?>(val data: T) : Outcome<T>()
    data class Failed(val throwable: Throwable) : Outcome<Nothing>()
}