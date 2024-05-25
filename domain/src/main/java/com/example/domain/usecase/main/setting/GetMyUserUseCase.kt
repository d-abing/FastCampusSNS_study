package com.example.domain.usecase.main.setting

import com.example.domain.model.User

interface GetMyUserUseCase {

    suspend operator fun invoke(): Result<User>
}