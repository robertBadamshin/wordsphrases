package com.wordphrases.data.model

import kotlinx.serialization.Serializable

@Serializable
data class WordFirebaseRemote(
    val wordId: Long,
    val createdAt: Long,
    val wordText: String,
    val maxRepeatCount: Long,
    val repeatCount: Long,
)