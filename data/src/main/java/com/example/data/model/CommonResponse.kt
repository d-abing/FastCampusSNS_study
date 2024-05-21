package com.example.data.model

import kotlinx.serialization.Serializable

@Serializable
data class CommonResponse<T> (
    val result: String,
    val data: T,
    val errorCode: String,
    val errorMessage: String,
)