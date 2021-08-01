package com.app.wordsphrases.add_word_impl.domain.entity

data class AddWordResult(
    val id: String,
    val text: String,
    val translation: String,
    val createdAt: Long,
    val imageUrl: String,
)