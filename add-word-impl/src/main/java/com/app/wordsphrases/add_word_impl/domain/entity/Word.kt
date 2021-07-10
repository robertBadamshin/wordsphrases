package com.app.wordsphrases.add_word_impl.domain.entity

data class Word(
    val id: String,
    val createdAt: Long,
    val text: String,
    val translation: String,
    val imageUrl: String,
)