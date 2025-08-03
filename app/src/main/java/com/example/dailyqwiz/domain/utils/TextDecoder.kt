package com.example.dailyqwiz.domain.utils

object TextDecoder {
    fun decode(string: String): String {
        return string
            .replace("&quot;", "\"")
            .replace("&#039;", "'")
            .replace("&amp;", "&")
            .replace("&lt;", "<")
            .replace("&gt;", ">")
            .replace("&eacute;", "é")
            .replace("&uuml;", "ü")
    }
}