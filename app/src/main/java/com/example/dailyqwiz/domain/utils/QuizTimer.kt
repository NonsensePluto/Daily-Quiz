package com.example.dailyqwiz.domain.utils

import android.os.CountDownTimer

object QuizTimer {
    var countDownTimer: CountDownTimer? = null

    fun startCountDown(
        totalTime: Long,
        intervalTime: Long,
        myOnTick:(Long) -> Unit,
        myOnFinish: () -> Unit
    ) {
        countDownTimer = object : CountDownTimer(totalTime, intervalTime)  {
            override fun onTick(millisUntilFinish: Long) {
                myOnTick(millisUntilFinish)
            }

            override fun onFinish() {
                myOnFinish()
            }
        }.start()
    }

    fun stopCountDown() {
        countDownTimer?.cancel()
    }

}