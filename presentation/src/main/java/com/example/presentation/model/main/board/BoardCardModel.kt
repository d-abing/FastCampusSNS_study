package com.example.presentation.model.main.board

data class BoardCardModel (
    val boardId: Long,
    val username: String,
    val images: List<String>,
    val text: String
)