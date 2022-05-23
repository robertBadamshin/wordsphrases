package com.wordphrases.domain.entity

private const val defaultId = -1L

data class LanguagePair(
    val pairId: Long = defaultId,
    val learningLanguageCode: String,
    val nativeLanguageCode: String,
    val selected: Boolean,
)