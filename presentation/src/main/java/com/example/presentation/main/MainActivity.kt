package com.example.presentation.main

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.domain.model.ACTION_POSTED
import com.example.presentation.main.board.BoardViewModel
import dagger.hilt.android.AndroidEntryPoint
import theme.ConnectedTheme

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val boardViewModel: BoardViewModel by viewModels()

    private val receiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if(intent?.action == ACTION_POSTED) {
                boardViewModel.load()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConnectedTheme {
                MainNavHost(boardViewModel)
            }
        }

        ContextCompat.registerReceiver(
            this,
            receiver,
            IntentFilter(ACTION_POSTED),
            ContextCompat.RECEIVER_NOT_EXPORTED,
        )
    }
}