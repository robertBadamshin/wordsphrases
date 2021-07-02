package com.app.wordsphrases.translation_impl.data.entity

import com.app.wordsphrases.translation_api.domain.TranslationResult
import com.google.gson.annotations.SerializedName

data class TranslationResultRemote(
    @SerializedName("translations")
    val translations: List<String>,
)

fun TranslationResultRemote.toDomainEntity(): TranslationResult {
    return TranslationResult(
        translations = translations
    )
}