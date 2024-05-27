package com.example.data.di

import com.example.data.usecase.main.board.DeleteBoardUseCaseImpl
import com.example.data.usecase.main.board.GetBoardUseCaseImpl
import com.example.domain.usecase.main.board.DeleteBoardUseCase
import com.example.domain.usecase.main.board.GetBoardUseCase
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
}