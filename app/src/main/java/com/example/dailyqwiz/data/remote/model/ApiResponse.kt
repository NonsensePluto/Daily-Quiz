package com.example.dailyqwiz.data.remote.model

import com.google.gson.annotations.SerializedName

data class ApiResponse (
    @SerializedName("response_code")
    val responseCode: Int,

    @SerializedName("results")
    val results: List<QuizQuestionResponse>
)