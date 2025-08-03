package com.example.dailyqwiz.domain.mapper

import com.example.dailyqwiz.data.database.entity.UserAnswersEntity
import com.example.dailyqwiz.domain.model.UserAnswer
import javax.inject.Inject

class UserAnswersDomainToDb @Inject constructor(){
    operator fun invoke(userAnswer: UserAnswer, quizId: Int): UserAnswersEntity {
        return UserAnswersEntity(
            id = 0,
            questionText = userAnswer.questionText,
            allOptions = userAnswer.allOptions.joinToString(";"),
            selected = userAnswer.selected,
            correctAnswer = userAnswer.correctAnswer,
            idQuiz = quizId
        )
    }
}