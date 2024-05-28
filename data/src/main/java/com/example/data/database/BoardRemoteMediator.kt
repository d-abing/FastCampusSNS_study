package com.example.data.database

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.data.model.BoardDTO
import com.example.data.retrofit.BoardService
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class BoardRemoteMediator @Inject constructor(
    private val database: BoardDatabase,
    private val service: BoardService,
) : RemoteMediator<Int, BoardDTO>() {

    private val boardDao = database.boardDao()
    private val remoteKeyDao = database.remoteKeyDao()
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, BoardDTO>
    ): MediatorResult {

        val remoteKey = when(loadType) {
            LoadType.REFRESH -> { null }
            LoadType.PREPEND -> { return MediatorResult.Success(true) }
            LoadType.APPEND -> { remoteKeyDao.getNextKey() }
        }

        try {
            val page = remoteKey?.nextPage ?: 1
            val loadSize = 10
            val response = service.getBoard(
                page = page,
                size = loadSize,
            )
            val boardList = response.data

            database.withTransaction {
                if(loadType == LoadType.REFRESH) {
                    boardDao.deleteAll()
                    remoteKeyDao.deleteAll()
                }
                remoteKeyDao.insertOrReplace(RemoteKey(nextPage = page + 1))
                boardDao.insertAll(boardList)
            }
            return MediatorResult.Success(loadSize != boardList.size)
        } catch (e: Exception) {
            return MediatorResult.Error(e)
        }
    }
}