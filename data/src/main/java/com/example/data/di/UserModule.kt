package com.example.data.di

import com.example.data.usecase.ClearTokenUseCaseImpl
import com.example.data.usecase.GetTokenUseCaseImpl
import com.example.data.usecase.LoginUseCaseImpl
import com.example.data.usecase.SetTokenUseCaseImpl
import com.example.data.usecase.SignUpUseCaseImpl
import com.example.data.usecase.main.setting.GetMyUserUseCaseImpl
import com.example.data.usecase.main.setting.SetMyUserUseCaseImpl
import com.example.data.usecase.main.setting.SetProfileImageUseCaseImpl
import com.example.domain.usecase.login.ClearTokenUseCase
import com.example.domain.usecase.login.GetTokenUseCase
import com.example.domain.usecase.login.LoginUseCase
import com.example.domain.usecase.login.SetTokenUseCase
import com.example.domain.usecase.login.SignUpUseCase
import com.example.domain.usecase.main.setting.GetMyUserUseCase
import com.example.domain.usecase.main.setting.SetMyUserUseCase
import com.example.domain.usecase.main.setting.SetProfileImageUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UserModule {

    @Binds
    abstract fun bindLoginUseCase(uc:LoginUseCaseImpl): LoginUseCase

    @Binds
    abstract fun bindSignUpUseCase(uc: SignUpUseCaseImpl): SignUpUseCase

    @Binds
    abstract fun bindGetTokenUseCase(uc: GetTokenUseCaseImpl): GetTokenUseCase

    @Binds
    abstract fun bindSetTokenUseCase(uc: SetTokenUseCaseImpl): SetTokenUseCase

    @Binds
    abstract fun bindClearTokenpUseCase(uc: ClearTokenUseCaseImpl): ClearTokenUseCase

    @Binds
    abstract fun bindGetMyUserUseCase(uc: GetMyUserUseCaseImpl): GetMyUserUseCase

    @Binds
    abstract fun updateMyNameUseCase(uc: SetMyUserUseCaseImpl): SetMyUserUseCase

    @Binds
    abstract fun setProfileImageUseCase(uc: SetProfileImageUseCaseImpl): SetProfileImageUseCase
}

