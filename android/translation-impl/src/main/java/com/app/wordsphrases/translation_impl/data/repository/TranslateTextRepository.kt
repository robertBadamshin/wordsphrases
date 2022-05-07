package com.app.wordsphrases.translation_impl.data.repository

import com.app.wordsphrases.translation_api.domain.Translation
import com.app.wordsphrases.translation_api.domain.TranslationResult
import com.app.wordsphrases.translation_impl.data.datasource.service.OxfordDictionaryService
import com.app.wordsphrases.translation_impl.data.entity.oxford.toTranslationsList
import com.app.wordsphrases.translation_impl.domain.OxfordGrammaticalFeatureId
import javax.inject.Inject

private const val syllableCode = 769

class TranslateTextRepository @Inject constructor(
    private val oxfordDictionaryService: OxfordDictionaryService,
) {
    private val disabledLexicalId = OxfordGrammaticalFeatureId.Imperfective

    suspend fun translateText(from: String, to: String, text: String): TranslationResult {
        val result = oxfordDictionaryService.translateWord(from, to, text)
        var id = 0

        val translations = result.toTranslationsList()
            .filter { translation ->
                !translation.featureIds.any { id -> id == disabledLexicalId }
            }
            .map { translation ->

                return@map translation.text
                    .filter { char -> char.code != syllableCode }
            }
            .distinct()
            .map { translationText ->
                Translation(
                    id = id++,
                    text = translationText,
                )
            }

        return TranslationResult(translations)
    }
}