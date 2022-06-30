package com.app.wordsphrases.entity.word

// todo remove
data class WordOld(
    val id: Int,
    val createdAt: Long,
    val word: String,
    val translations: List<String>,
    val imageUrl: String?,
)