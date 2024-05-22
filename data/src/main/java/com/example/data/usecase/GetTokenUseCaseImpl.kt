package com.example.data.usecase

import com.example.data.UserDataStore
import com.example.domain.usecase.login.GetTokenUseCase
import javax.inject.Inject

class GetTokenUseCaseImpl @Inject constructor(
    private val userDataStore: UserDataStore
): GetTokenUseCase {
    override suspend fun invoke(): String? {
        return userDataStore.getToken()
    }
}