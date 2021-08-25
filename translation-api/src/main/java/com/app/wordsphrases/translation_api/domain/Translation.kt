package com.app.wordsphrases.translation_api.domain

data class Translation(
    val id: Int,
    val text: String,
    val confidence: Float,
)