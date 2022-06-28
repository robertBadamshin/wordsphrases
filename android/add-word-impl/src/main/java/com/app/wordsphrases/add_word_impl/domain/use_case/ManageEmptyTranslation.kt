package com.app.wordsphrases.add_word_impl.domain.use_case

import com.app.wordsphrases.add_word_impl.data.WordRepository
import com.app.wordsphrases.add_word_impl.domain.entity.Translation
import javax.inject.Inject

class ManageEmptyTranslation @Inject constructor(
    private val wordRepository: WordRepository,
) {

    operator fun invoke() {
        val translations = wordRepository.requireTranslations()

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
            id = wordRepository.getNextTranslationId(),
            text = "",
        )

        val newTranslations = translations
            .plus(emptyTranslation)

        wordRepository.setTranslations(newTranslations)
    }
}