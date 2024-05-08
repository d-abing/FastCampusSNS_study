package com.example.practice

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named


@Module
@InstallIn(SingletonComponent::class)
class FooModule {

    @Named("foo 1")
    @Provides
    fun provideFoo1(): Foo {
        return Foo(id = "Foo 1")
    }

    @Provides
    fun provideFoo2(): Foo {
        return Foo(id = "Foo 2")
    }
}