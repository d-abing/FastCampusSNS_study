package com.example.practice

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import kotlin.random.Random

@Module
@InstallIn(DialogComponent::class)
object DialogModule {

    @Provides
    fun porivdeUser(): User {
        return User("Dabin")
    }

    @Provides
    @DialogScoped
    fun provideRandomNumber(): Int {
        return Random.nextInt(1000)
    }
}