package com.app.wordsphrases.translation_impl.data.entity

import com.app.wordsphrases.translation_api.domain.Translation
import com.google.gson.annotations.SerializedName

data class TextTranslationItemRemote(
    @SerializedName("text")
    val text: String,
)

fun TextTranslationItemRemote.toDomainEntity(id: Int): Translation {
    return Translation(
        id = id,
        text = this.text,
    )
}