package com.example.data.usecase.main.setting

import com.example.data.model.toDomainModel
import com.example.data.retrofit.UserService
import com.example.domain.model.User
import com.example.domain.usecase.main.setting.GetMyUserUseCase
import javax.inject.Inject

class GetMyUserUseCaseImpl @Inject constructor(
    private val userService: UserService
) : GetMyUserUseCase {
    override suspend fun invoke(): Result<User> = kotlin.runCatching {
        userService.getMyPage().data.toDomainModel()
    }
}