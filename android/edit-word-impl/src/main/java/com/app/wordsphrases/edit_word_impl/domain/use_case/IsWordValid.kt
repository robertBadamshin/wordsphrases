package com.app.wordsphrases.edit_word_impl.domain.use_case

import com.app.wordsphrases.edit_word_impl.data.EditWordRepository
import javax.inject.Inject

class IsWordValid @Inject constructor(
    private val editWordRepository: EditWordRepository,
) {

    operator fun invoke(): Boolean {
        val wordText = editWordRepository.getCurrentWordText()
        val translations = editWordRepository.getCurrentTranslations()
        val hasFilledTranslations = translations
            .any { translation -> translation.text.isNotBlank() }

        return wordText.isNotBlank() && hasFilledTranslations
    }
}