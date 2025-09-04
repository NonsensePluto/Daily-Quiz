package com.example.dailyqwiz.data.repository.di

import com.example.dailyqwiz.data.repository.QuizApiRepositoryImpl
import com.example.dailyqwiz.data.repository.QuizRepositoryImpl
import com.example.dailyqwiz.domain.repository.QuizApiRepository
import com.example.dailyqwiz.domain.repository.QuizRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindQuizRepository(
        quizRepositoryImpl: QuizRepositoryImpl
    ): QuizRepository

    @Binds
    @Singleton
    abstract fun bindQuizApiRepository(
        quizApiRepositoryImpl: QuizApiRepositoryImpl
    ): QuizApiRepository
}