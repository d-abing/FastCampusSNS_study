package com.example.practice

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    val TAG: String = App::class.java.simpleName

    override fun onCreate() {
        super.onCreate()
    }
}