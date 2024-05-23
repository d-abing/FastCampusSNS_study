package com.example.data.usecase.main.setting

import com.example.data.model.UpdateMyInfoParam
import com.example.data.retrofit.UserService
import com.example.domain.usecase.main.setting.GetMyUserUseCase
import com.example.domain.usecase.main.setting.SetMyUserUseCase
import javax.inject.Inject

class SetMyUserUseCaseImpl @Inject constructor(
    private val userService: UserService,
    private val getMyUserUseCase: GetMyUserUseCase
) : SetMyUserUseCase {
    override suspend fun invoke(
        username: String?,
        profileImageUrl: String?,
    ): Result<Unit> = kotlin.runCatching{
        val user = getMyUserUseCase().getOrThrow()
        val requestBody = UpdateMyInfoParam(
            userName = username?:user.username,
            extraUserInfo = "",
            profileFilePath = profileImageUrl?:user.profileImageUrl.orEmpty()
        ).toRequestBody()
        userService.patchMyPage(requestBody)
    }
}