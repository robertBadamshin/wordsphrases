package com.app.wordsphrases.entity.word

data class Word(
    val id: Int,
    val createdAt: Long,
    val word: String,
    val translation: String,
    val imageUrl: String?,
)