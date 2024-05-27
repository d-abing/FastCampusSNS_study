package com.example.data.usecase.main.board

import com.example.data.retrofit.BoardService
import com.example.domain.usecase.main.board.DeleteBoardUseCase
import javax.inject.Inject

class DeleteBoardUseCaseImpl @Inject constructor(
    private val boardService: BoardService
) : DeleteBoardUseCase {
    override suspend fun invoke(boardId: Long): Result<Long> = kotlin.runCatching{
        boardService.deleteBoard(boardId).data
    }
}