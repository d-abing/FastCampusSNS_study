package com.example.data.di

import com.example.data.usecase.main.writing.GetImageListUseCaseImpl
import com.example.domain.usecase.main.writing.GetImageListUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class WritingModule {

    @Binds
    abstract fun bindGetImageListUseCase(uc: GetImageListUseCaseImpl): GetImageListUseCase
}