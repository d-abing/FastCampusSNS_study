package com.example.data.di

import android.content.Context
import androidx.room.Room
import com.example.data.database.BoardDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SingletonModule {

    companion object {
        @Provides
        fun provideBoardDatabase(context: Context): BoardDatabase {
            return Room.databaseBuilder(
                context,
                BoardDatabase::class.java,
                "BoardDatabase"
            ).build()
        }
    }
}