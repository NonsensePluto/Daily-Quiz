package com.example.dailyqwiz.data.database.appdatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dailyqwiz.data.database.dao.QuizDao
import com.example.dailyqwiz.data.database.entity.QuizEntity
import com.example.dailyqwiz.data.database.entity.UserAnswersEntity

@Database(
    entities = [
        QuizEntity::class,
        UserAnswersEntity::class
               ],
    version = 1,
    exportSchema = false
)
abstract class AppDataBase : RoomDatabase(){
    abstract fun quizDao() : QuizDao
}