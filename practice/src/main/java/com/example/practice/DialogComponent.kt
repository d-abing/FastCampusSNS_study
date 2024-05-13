package com.example.practice

import dagger.hilt.DefineComponent
import dagger.hilt.android.components.ActivityComponent

@DefineComponent(parent = ActivityComponent::class)
@DialogScoped
interface DialogComponent {
}