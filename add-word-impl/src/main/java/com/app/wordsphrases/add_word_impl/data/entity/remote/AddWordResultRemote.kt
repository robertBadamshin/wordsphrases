package com.app.wordsphrases.add_word_impl.data.entity.remote

import com.app.wordsphrases.add_word_impl.domain.entity.AddWordResult
import com.google.gson.annotations.SerializedName

data class AddWordResultRemote(
    @SerializedName("id")
    val id: String,
    @SerializedName("created_at")
    val createdAt: Long,
    @SerializedName("imageUrl")
    val imageUrl: String,
)

fun AddWordResultRemote.toDomainEntity(): AddWordResult {
    return AddWordResult(
        id = id,
        createdAt = createdAt,
        imageUrl = imageUrl,
    )
}