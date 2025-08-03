package com.example.dailyqwiz.domain.utils

object ResultPhrasesGenerator {
    fun getResultPhrases(result: Int, max: Int): Pair<String, String> {
        return when (result) {
            max -> "Идеально!" to "$result/$max — вы ответили на всё правильно. Это блестящий результат!"
            max - 1 -> "Почти идеально!" to "$result/$max — очень близко к совершенству. Ещё один шаг!"
            max - 2 -> "Хороший результат!" to "$result/$max — вы на верном пути. Продолжайте тренироваться!"
            max - 3 -> "Есть над чем поработать" to "$result/$max — не расстраивайтесь, попробуйте ещё раз!"
            1 -> "Сложный вопрос?" to "$result/$max — иногда просто не ваш день. Следующая попытка будет лучше!"
            else -> "Бывает и так!" to "$result/$max — не отчаивайтесь. Начните заново и удивите себя!"
        }
    }
}