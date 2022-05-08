package com.wordphrases.domain.entity

data class Word(
    val wordId: Long,
    val createdAt: Long,
    val wordText: String,
    val sortOrder: Long,
    val maxRepeatCount: Long,
    val repeatCount: Long,
)