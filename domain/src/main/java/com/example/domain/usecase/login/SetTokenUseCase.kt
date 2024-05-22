package com.example.domain.usecase.login

interface SetTokenUseCase {
    suspend operator fun invoke(token: String)
}