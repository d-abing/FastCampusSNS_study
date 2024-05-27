package com.example.domain.model

import kotlinx.serialization.Serializable

data class Board (
    val id: Long,
    val title: String,
    val content: String,
    val images: List<String>,
    val username: String,
    val profileImageUrl: String,
)