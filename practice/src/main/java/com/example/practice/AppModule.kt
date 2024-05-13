package com.example.practice

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.ElementsIntoSet
import dagger.multibindings.IntKey
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @IntoSet
    fun provideOneString(): String {
        return "ABC"
    }

    @Provides
    @ElementsIntoSet
    fun provideMultipleString(): Set<String> {
        return listOf<String>("DEF", "GHI").toSet()
    }

    @Provides
    @IntoMap
    @IntKey(100)
    fun provideIntString1(): String {
        return "백점"
    }

    @Provides
    @IntoMap
    @IntKey(90)
    fun provideIntString2(): String {
        return "구십점"
    }

    @Provides
    @IntoMap
    @AnimalKey(Animal.DOG)
    fun provideDog(): String {
        return "멍멍이"
    }

    @Provides
    @IntoMap
    @AnimalKey(Animal.CAT)
    fun provideCat(): String {
        return "고양이"
    }
}