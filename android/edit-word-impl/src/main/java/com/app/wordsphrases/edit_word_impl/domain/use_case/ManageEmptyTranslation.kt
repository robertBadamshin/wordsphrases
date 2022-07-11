package com.app.wordsphrases.edit_word_impl.domain.use_case

import com.app.wordsphrases.edit_word_impl.data.EditWordRepository
import com.app.wordsphrases.edit_word_impl.domain.entity.Translation
import javax.inject.Inject

class ManageEmptyTranslation @Inject constructor(
    private val editWordRepository: EditWordRepository,
) {

    operator fun invoke() {
        val translations = editWordRepository.requireTranslations()

        val lastNotEmptyTranslationIndex = translations.indexOfLast { translation ->
            translation.text.isNotBlank()
        }

        if (lastNotEmptyTranslationIndex == -1) {
            return
        }

        if (lastNotEmptyTranslationIndex == translations.lastIndex - 1) {
            return
        }

        val emptyTranslation = Translation(
            id = editWordRepository.getNextTranslationId(),
            text = "",
        )

        val newTranslations = translations
            .plus(emptyTranslation)

        editWordRepository.setTranslations(newTranslations)
    }
}