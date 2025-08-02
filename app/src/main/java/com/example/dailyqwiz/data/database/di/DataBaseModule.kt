package com.example.dailyqwiz.data.database.di

import android.content.Context
import androidx.room.Room
import com.example.dailyqwiz.data.database.appdatabase.AppDataBase
import com.example.dailyqwiz.data.database.dao.QuizDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDataBase {
        return Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            "DaylyQuizDatabase"
        ).build()
    }

    @Provides
    fun provideQuizDao(database: AppDataBase): QuizDao {
        return database.quizDao()
    }
}