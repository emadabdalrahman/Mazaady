package com.example.mazaady.utils

fun Any.tag(): String {
    return this::class.java.simpleName
}