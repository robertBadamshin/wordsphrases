package com.app.wordsphrases.add_word_impl.domain.use_case

import com.app.wordsphrases.add_word_impl.data.AddWordRepository
import javax.inject.Inject

class UpdateTranslation @Inject constructor(
    private val addWordRepository: AddWordRepository,
) {

    operator fun invoke(translationId: Int, text: String) {
        val translations = addWordRepository.requireTranslations().toMutableList()

        val translationIndex = translations.indexOfFirst { translation ->
            translation.id == translationId
        }

        if (translationIndex == -1) {
            throw IllegalStateException("translation don't exist")
        }

        val targetTranslation = translations[translationIndex]
        val updatedTranslation = targetTranslation.copy(text = text)
        translations[translationIndex] = updatedTranslation

        addWordRepository.setTranslations(translations)
    }
}