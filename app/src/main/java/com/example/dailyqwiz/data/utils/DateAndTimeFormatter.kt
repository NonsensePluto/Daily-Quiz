package com.example.dailyqwiz.data.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DateAndTimeFormatter {
    fun formatDate(timestamp: Long): String {
        val sdf = SimpleDateFormat("d MMMM", Locale("ru"))
        return sdf.format(Date(timestamp))
    }

    fun formatTime(timestamp: Long): String {
        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
        return sdf.format(Date(timestamp))
    }
}