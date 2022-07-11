package com.app.wordsphrases.edit_word_impl.domain.use_case

import com.app.wordsphrases.edit_word_impl.data.EditWordRepository
import javax.inject.Inject

class UpdateTranslation @Inject constructor(
    private val editWordRepository: EditWordRepository,
) {

    operator fun invoke(translationId: Int, text: String) {
        val translations = editWordRepository.requireTranslations().toMutableList()

        val translationIndex = translations.indexOfFirst { translation ->
            translation.id == translationId
        }

        if (translationIndex == -1) {
            throw IllegalStateException("translation don't exist")
        }

        val targetTranslation = translations[translationIndex]
        val updatedTranslation = targetTranslation.copy(text = text)
        translations[translationIndex] = updatedTranslation

        editWordRepository.setTranslations(translations)
    }
}