package com.example.data.usecase.main.board

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.data.database.BoardDatabase
import com.example.data.database.BoardRemoteMediator
import com.example.data.model.toDomainModel
import com.example.domain.model.Board
import com.example.domain.usecase.main.board.GetBoardUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetBoardUseCaseImpl @Inject constructor(
    private val boardDatabase: BoardDatabase,
    private val mediator: BoardRemoteMediator,
) : GetBoardUseCase {

    @OptIn(ExperimentalPagingApi::class)
    override suspend fun invoke(): Result<Flow<PagingData<Board>>> = kotlin.runCatching {
        Pager(
            config = PagingConfig(
                pageSize = 10,
                initialLoadSize = 10
            ),
            remoteMediator = mediator,
            pagingSourceFactory = {
                boardDatabase.boardDao().getAll()
            },
        ).flow.map { pagingData ->
            pagingData.map { it.toDomainModel() }
        }
    }
}