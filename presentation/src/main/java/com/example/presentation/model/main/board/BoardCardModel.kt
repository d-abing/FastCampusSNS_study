package com.example.presentation.model.main.board

import com.example.domain.model.Board
import com.example.domain.model.Comment
import javax.annotation.concurrent.Immutable

@Immutable
data class BoardCardModel (
    val userId: Long,
    val boardId: Long,
    val username: String,
    val images: List<String>,
    val text: String,
    val comments: List<Comment>
)

fun Board.toUiModel(): BoardCardModel {
    return BoardCardModel(
        userId = this.userId,
        boardId = this.id,
        username = this.username,
        images = this.images,
        text = this.content,
        comments = this.comments
    )
}