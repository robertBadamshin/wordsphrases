package com.app.wordsphrases.translation_impl.data.entity

import com.app.wordsphrases.translation_api.domain.Translation
import com.google.gson.annotations.SerializedName

data class TranslationItemRemote(
    @SerializedName("displayTarget")
    val text: String,
    @SerializedName("confidence")
    val confidence: Float,
)

fun TranslationItemRemote.toDomainEntity(id: Int): Translation {
    return Translation(
        id = id,
        text = text,
        confidence = confidence,
    )
}