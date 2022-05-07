package com.app.wordsphrases.translation_impl.data.entity

import com.app.wordsphrases.translation_api.domain.TranslationResult
import com.google.gson.annotations.SerializedName

data class DictionaryTranslationResultRemote(
    @SerializedName("translations")
    val dictionaryTranslations: List<DictionaryTranslationItemRemote>,
)

fun DictionaryTranslationResultRemote.toDomainEntity(): TranslationResult {
    val translations = dictionaryTranslations.mapIndexed { index, translation -> translation.toDomainEntity(id = index) }
    return TranslationResult(
        translations = translations,
    )
}