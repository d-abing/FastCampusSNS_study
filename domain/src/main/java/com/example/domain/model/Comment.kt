package com.example.domain.model

data class Comment (
    val id: Long,
    val text: String,
    val username: String,
    val profileImageUrl: String? = null
)