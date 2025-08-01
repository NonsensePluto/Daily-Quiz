package com.example.dailyqwiz.domain.mapper

import com.example.dailyqwiz.data.remote.model.QuizQuestionResponse
import com.example.dailyqwiz.domain.model.QuizQuestionModel
import javax.inject.Inject

class QuizQuestionResponseToModel @Inject constructor() {
    operator fun invoke(quizQuestionResponse: QuizQuestionResponse): QuizQuestionModel {//Странно думал что здесь есть оверайд
        return QuizQuestionModel(
            quizQuestionResponse.question,
            quizQuestionResponse.correctAnswer,
            quizQuestionResponse.incorrectAnswers
        )
    }
}