package com.example.dailyqwiz.data.mappers

import com.example.dailyqwiz.data.database.entity.UserAnswersEntity
import com.example.dailyqwiz.domain.model.UserAnswersHistory
import javax.inject.Inject

class UserAnswersDbToDomain @Inject constructor() {
    operator fun invoke(userAnswerEntity: UserAnswersEntity): UserAnswersHistory {

        return UserAnswersHistory(
            questionText = userAnswerEntity.questionText,
            allOptions = userAnswerEntity.allOptions.split(";"),
            selected = userAnswerEntity.selected,
            correctAnswer = userAnswerEntity.correctAnswer
        )
    }

}