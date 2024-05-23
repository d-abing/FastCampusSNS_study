package com.example.data.di

import com.example.data.usecase.file.GetImageUseCaseImpl
import com.example.data.usecase.file.GetInputStreamUseCaseImpl
import com.example.data.usecase.file.UploadImageUseCaseImpl
import com.example.domain.usecase.file.GetImageUseCase
import com.example.domain.usecase.file.GetInputStreamUseCase
import com.example.domain.usecase.file.UploadImageUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FileModule {

    @Binds
    abstract fun bindGetInputStreamUseCase(uc: GetInputStreamUseCaseImpl): GetInputStreamUseCase

    @Binds
    abstract fun bindGetImageUseCase(uc: GetImageUseCaseImpl): GetImageUseCase

    @Binds
    abstract fun bindUploadImageUseCase(uc: UploadImageUseCaseImpl): UploadImageUseCase
}