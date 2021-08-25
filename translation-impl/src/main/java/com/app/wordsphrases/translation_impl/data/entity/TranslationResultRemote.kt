package com.app.wordsphrases.translation_impl.data.entity

import com.app.wordsphrases.translation_api.domain.TranslationResult
import com.google.gson.annotations.SerializedName

data class TranslationResultRemote(
    @SerializedName("translations")
    val translations: List<TranslationItemRemote>,
)

fun TranslationResultRemote.toDomainEntity(): TranslationResult {
    val translations = translations.mapIndexed { index, translation -> translation.toDomainEntity(id = index) }
    return TranslationResult(
        translations = translations,
    )
}