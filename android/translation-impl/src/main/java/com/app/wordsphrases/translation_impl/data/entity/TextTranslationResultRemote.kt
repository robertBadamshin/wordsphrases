package com.app.wordsphrases.translation_impl.data.entity

import com.app.wordsphrases.translation_api.domain.TranslationResult
import com.google.gson.annotations.SerializedName

data class TextTranslationResultRemote(
    @SerializedName("translations")
    val translations: List<TextTranslationItemRemote>,
)

fun TextTranslationResultRemote.toDomainEntity(): TranslationResult {
    val translations = translations.mapIndexed { index, translation -> translation.toDomainEntity(id = index) }
    return TranslationResult(
        translations = translations,
    )
}