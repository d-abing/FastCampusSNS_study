package com.example.presentation.main.writing

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import theme.ConnectedTheme

@AndroidEntryPoint
class WritingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ConnectedTheme {
                WritingNavHost()
            }
        }
    }
}