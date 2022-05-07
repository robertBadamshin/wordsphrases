package com.app.wordsphrases.translation_impl.data.entity.oxford

import com.app.wordsphrases.translation_impl.domain.entity.OxfordTranslation
import com.google.gson.annotations.SerializedName

data class OxfordTranslationResponse(
    @SerializedName("results")
    val results: List<OxfordTranslationResultRemote>,
)

fun OxfordTranslationResponse.toTranslationsList(): List<OxfordTranslation> {
    val firstResult = results.first()
    val lexicalEntries = firstResult.lexicalEntries
    return lexicalEntries.flatMap { entriesHolder ->

        val entries = entriesHolder.entries
        entries.flatMap { lexicalEntry ->
            getTranslationsListFromLexicalEntry(lexicalEntry)
        }
    }

}

private fun getTranslationsListFromLexicalEntry(
    lexicalEntry: OxfordTranslationLexicalEntryRemote,
): List<OxfordTranslation> {
    return lexicalEntry.senses.orEmpty().flatMap { sense ->
        getTranslationsFromSense(sense)
    }
}

private fun getTranslationsFromSense(sense: OxfordTranslationSenseRemote): List<OxfordTranslation> {
    return sense.translations
        .map { translation ->
            val featureGrammaticalIds = translation
                .oxfordGrammaticalFeatures
                .orEmpty()
                .mapNotNull { feature -> feature.id.toTranslationsList() }

            OxfordTranslation(
                text = translation.text,
                featureIds = featureGrammaticalIds,
            )
        }
}