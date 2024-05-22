package com.example.domain.usecase.login

interface GetTokenUseCase {
    suspend operator fun invoke(): String?
}