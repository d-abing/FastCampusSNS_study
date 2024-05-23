package com.example.domain.usecase.main.setting

interface SetProfileImageUseCase {
    suspend operator fun invoke(contentUri: String): Result<Unit>
}