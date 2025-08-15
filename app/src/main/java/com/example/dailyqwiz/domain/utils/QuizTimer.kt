package com.example.dailyqwiz.domain.utils

import android.os.CountDownTimer

class QuizTimer(
    val totalTime: Long = 30000L,
    val intervalTime: Long = 1000L,
    val onTick: (Long) -> Unit,
    val onFinish: () -> Unit
) {
    private var countDownTimer: CountDownTimer? = null

    fun startCountDown() {
        countDownTimer = object : CountDownTimer(totalTime, intervalTime)  {
            override fun onTick(millisUntilFinish: Long) {
                onTick(millisUntilFinish)
            }

            override fun onFinish() {
                onFinish()
            }
        }.start()
    }

    fun stopCountDown() {
        countDownTimer?.cancel()
    }

}