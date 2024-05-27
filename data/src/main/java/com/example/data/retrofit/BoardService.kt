package com.example.data.retrofit

import com.example.data.model.BoardDTO
import com.example.data.model.CommonResponse
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface BoardService {

    @GET("boards")
    suspend fun getBoard(
        @Query("page") page: Int,
        @Query("size") size: Int,
    ): CommonResponse<List<BoardDTO>>

    @POST("boards")
    suspend fun postBoard(
        @Body requestBody: RequestBody
    ): CommonResponse<Long>

    @DELETE("boards/{id}")
    suspend fun deleteBoard(
        @Path("id") id: Long
    ): CommonResponse<Long>

    @POST("boards/{id}/comments")
    suspend fun postComment(
        @Path("id") boardId: Long,
        @Body requestBody: RequestBody
    ): CommonResponse<Long>

    @DELETE("boards/{board-id}/comments/{comment-id}")
    suspend fun deleteComment(
        @Path("board-id") boardId: Long,
        @Path("comment-id") commentId: Long,
    ): CommonResponse<Long>
}