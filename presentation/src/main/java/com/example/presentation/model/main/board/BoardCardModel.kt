package com.example.presentation.model.main.board

import com.example.domain.model.Board
import com.example.domain.model.Comment
import com.mohamedrejeb.richeditor.model.RichTextState
import javax.annotation.concurrent.Immutable

@Immutable
data class BoardCardModel (
    val userId: Long,
    val boardId: Long,
    val username: String,
    val profileImageUrl: String,
    val images: List<String>,
    val richTextState: RichTextState,
    val comments: List<Comment>
)

fun Board.toUiModel(): BoardCardModel {
    return BoardCardModel(
        userId = this.userId,
        boardId = this.id,
        username = this.username,
        profileImageUrl = this.profileImageUrl,
        images = this.images,
        richTextState = RichTextState().apply { setHtml(this@toUiModel.content) },
        comments = this.comments
    )
}