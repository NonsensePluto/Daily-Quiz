package com.example.dailyqwiz.domain.usecases.database

import com.example.dailyqwiz.domain.model.QuizHistory
import com.example.dailyqwiz.domain.repository.QuizRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllQuizHistoryUseCase @Inject constructor(
    private val repository: QuizRepository
) {
    operator fun invoke(): Flow<List<QuizHistory>> = repository.getAllHistory()
}
