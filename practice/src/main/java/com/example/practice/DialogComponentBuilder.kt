package com.example.practice

import dagger.BindsInstance
import dagger.hilt.DefineComponent
import java.time.LocalDateTime

@DefineComponent.Builder
interface DialogComponentBuilder {
    fun setLocalDateTime(
        @BindsInstance localDateTime: LocalDateTime
    ): DialogComponentBuilder
    fun build(): DialogComponent
}