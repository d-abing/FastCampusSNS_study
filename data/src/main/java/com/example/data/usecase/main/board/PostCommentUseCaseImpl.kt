package com.example.data.usecase.main.board

import com.example.data.model.comment.CommentParam
import com.example.data.retrofit.BoardService
import com.example.domain.usecase.main.board.PostCommentUseCase
import javax.inject.Inject

class PostCommentUseCaseImpl @Inject constructor(
    private val boardService: BoardService
) : PostCommentUseCase {
    override suspend fun invoke(boardId: Long, text: String): Result<Long> = kotlin.runCatching{
        val requestBody = CommentParam(text).toRequestBody()
        boardService.postComment(
            boardId = boardId,
            requestBody = requestBody
        ).data
    }
}