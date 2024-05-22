package com.example.data.usecase

import com.example.data.UserDataStore
import com.example.domain.usecase.login.SetTokenUseCase
import javax.inject.Inject

class SetTokenUseCaseImpl @Inject constructor(
    private val userDataStore: UserDataStore
) : SetTokenUseCase {
    override suspend fun invoke(token: String) {
        userDataStore.setToken(token)
    }
}