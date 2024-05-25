package com.example.data.retrofit

import com.example.data.model.CommonResponse
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

interface BoardService {

    @POST("boards")
    suspend fun postBoard(
        @Body requestBody: RequestBody
    ): CommonResponse<Long>
}