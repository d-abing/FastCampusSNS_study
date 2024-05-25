package com.example.data.usecase.main.writing

import android.content.Context
import android.content.Intent
import com.example.data.model.BoardParcel
import com.example.data.service.PostingService
import com.example.domain.model.Image
import com.example.domain.usecase.main.writing.PostBoardUseCase
import javax.inject.Inject

class PostBoardUseCaseImpl @Inject constructor(
    private val context: Context
) : PostBoardUseCase {

    override suspend fun invoke(title: String, content: String, images: List<Image>) {
        val board = BoardParcel(title = title, content = content, images = images)
        context.startForegroundService(
            Intent(
                context,
                PostingService::class.java
            ).apply {
                putExtra(PostingService.EXTRA_BOARD, board)
            }
        )
    }
}