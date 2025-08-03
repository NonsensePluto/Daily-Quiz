package com.example.dailyqwiz.domain.mapper

import com.example.dailyqwiz.data.database.entity.QuizEntity
import javax.inject.Inject

class QuizDomainToDb @Inject constructor() {

    operator fun invoke(title: String, points: Int): QuizEntity {
        val now = System.currentTimeMillis()
        return QuizEntity(// мб вставить id
            title = title,
            date = now,
            time = now,
            points = points
        )
    }

}