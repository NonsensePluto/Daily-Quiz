package com.example.dailyqwiz.data.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "users_answers",
    foreignKeys = [
        ForeignKey(
            entity = QuizEntity::class,
            parentColumns = ["id"],
            childColumns = ["idQuiz"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class UserAnswersEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val questionText: String,
    val allOptions: String,
    val selected: String,
    val correctAnswer: String,
    val idQuiz: Int,
)