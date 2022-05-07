package com.app.wordsphrases.entity.word

data class Word(
    val id: Int,
    val createdAt: Long,
    val word: String,
    val translations: List<String>,
    val imageUrl: String?,
)