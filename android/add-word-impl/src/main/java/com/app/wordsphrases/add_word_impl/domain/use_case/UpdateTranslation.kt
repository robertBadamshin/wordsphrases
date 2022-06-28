package com.app.wordsphrases.add_word_impl.domain.use_case

import com.app.wordsphrases.add_word_impl.data.WordRepository
import javax.inject.Inject

class UpdateTranslation @Inject constructor(
    private val wordRepository: WordRepository,
) {

    operator fun invoke(translationId: Int, text: String) {
        val translations = wordRepository.requireTranslations().toMutableList()

        val translationIndex = translations.indexOfFirst { translation ->
            translation.id == translationId
        }

        if (translationIndex == -1) {
            throw IllegalStateException("translation don't exist")
        }

        val targetTranslation = translations[translationIndex]
        val updatedTranslation = targetTranslation.copy(text = text)
        translations[translationIndex] = updatedTranslation

        wordRepository.setTranslations(translations)
    }
}