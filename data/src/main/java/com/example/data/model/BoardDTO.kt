package com.example.data.model

import com.example.domain.model.Board
import kotlinx.serialization.Serializable

@Serializable
data class BoardDTO (
    val id: Long,
    val title: String,
    val content: String,
    val createdAt: String,
    val updatedAt: String,
    val createUserId: Long,
    val createUserName: String,
    val createUserProfileFilePath: String,
)

fun BoardDTO.toDomainModel(): Board{
    return Board(
        id = this.id,
        title = this.title,
        content = this.content,
        images = emptyList(),
        username = this.createUserName,
        profileImageUrl = this.createUserProfileFilePath
    )
}