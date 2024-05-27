package com.example.presentation.model.main.board

import com.example.domain.model.Board
import javax.annotation.concurrent.Immutable

@Immutable
data class BoardCardModel (
    val boardId: Long,
    val username: String,
    val images: List<String>,
    val text: String
)

fun Board.toUiModel(): BoardCardModel {
    return BoardCardModel(
        boardId = this.id,
        username = this.username,
        images = this.images,
        text = this.content
    )
}