package com.wordphrases.domain.entity

private const val defaultId = -1L

data class Word(
    val wordId: WordId = defaultId,
    val languagePairId: Long,
    val createdAt: Long,
    val wordText: String,
    val sortOrder: Long,
    val maxRepeatCount: Long,
    val repeatCount: Long,
    val translations: List<String>,
    val comment: String?,
)