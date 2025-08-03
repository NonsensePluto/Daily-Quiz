package com.example.dailyqwiz.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dailyqwiz.data.database.entity.QuizEntity
import com.example.dailyqwiz.data.database.entity.UserAnswersEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface QuizDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuiz(quiz: QuizEntity): Long

    @Query("SELECT * FROM quiz_table ORDER BY title Desc")
    fun getAllQuizzes(): Flow<List<QuizEntity>>

    @Query("SELECT COUNT(*) FROM quiz_table")
    fun getCountOfQuizzes(): Int

    @Query("SELECT * FROM quiz_table WHERE id = :id")
    suspend fun getQuizById(id: Int): QuizEntity?

    @Delete
    suspend fun deleteQuiz(quiz: QuizEntity)

    @Query("SELECT * FROM users_answers WHERE idQuiz = :quizId")
    suspend fun getUserAnswersForQuiz(quizId: Int): List<UserAnswersEntity>

    @Query("DELETE FROM users_answers WHERE idQuiz = :quizId")
    suspend fun deleteUserAnswersForQuiz(quizId: Int)

    @Query("SELECT * FROM users_answers WHERE idQuiz = :quizId")
    suspend fun getAnswersForQuiz(quizId: Int): List<UserAnswersEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnswer(answer: UserAnswersEntity)

    @Delete
    suspend fun deleteAnswer(answer: UserAnswersEntity)
}