package com.app.wordsphrases.add_word_impl.domain.use_case

import com.app.wordsphrases.add_word_impl.data.AddWordRepository
import javax.inject.Inject

class IsWordValid @Inject constructor(
    private val addWordRepository: AddWordRepository,
) {

    operator fun invoke(): Boolean {
        val wordText = addWordRepository.getCurrentWordText()
        val translations = addWordRepository.getCurrentTranslations()
        val hasFilledTranslations = translations
            .any { translation -> translation.text.isNotBlank() }

        return wordText.isNotBlank() && hasFilledTranslations
    }
}