package com.example.practice

import dagger.hilt.internal.GeneratedComponentManager
import java.time.LocalDateTime
import javax.inject.Inject

class DialogComponentManager @Inject constructor(
    private val dialogComponentBuilder: DialogComponentBuilder
) : GeneratedComponentManager<DialogComponent> {
    override fun generatedComponent(): DialogComponent {
        return dialogComponentBuilder
            .setLocalDateTime(LocalDateTime.now())
            .build()
    }
}
