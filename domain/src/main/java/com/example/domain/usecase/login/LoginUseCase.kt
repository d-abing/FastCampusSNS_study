package com.example.domain.usecase.login

interface LoginUseCase {

    suspend operator fun invoke(
        id: String,
        password: String
    ): Result<String>
}