package com.example.domain.usecase.main.board

interface DeleteCommentUseCase {
    suspend operator fun invoke(
        boardId: Long,
        commentId: Long,
    ): Result<Long>
}