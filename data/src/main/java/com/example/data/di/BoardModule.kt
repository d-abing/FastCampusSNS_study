package com.example.data.di

import com.example.data.usecase.main.board.DeleteBoardUseCaseImpl
import com.example.data.usecase.main.board.DeleteCommentUseCaseImpl
import com.example.data.usecase.main.board.GetBoardUseCaseImpl
import com.example.data.usecase.main.board.PostCommentUseCaseImpl
import com.example.domain.usecase.main.board.DeleteBoardUseCase
import com.example.domain.usecase.main.board.DeleteCommentUseCase
import com.example.domain.usecase.main.board.GetBoardUseCase
import com.example.domain.usecase.main.board.PostCommentUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class BoardModule {

    @Binds
    abstract fun bindGetBoardUseCase(uc: GetBoardUseCaseImpl): GetBoardUseCase

    @Binds
    abstract fun bindDeleteBoardUseCase(uc: DeleteBoardUseCaseImpl): DeleteBoardUseCase

    @Binds
    abstract fun bindPostCommentUseCase(uc: PostCommentUseCaseImpl): PostCommentUseCase

    @Binds
    abstract fun bindDeleteCommentUseCase(uc: DeleteCommentUseCaseImpl): DeleteCommentUseCase
}