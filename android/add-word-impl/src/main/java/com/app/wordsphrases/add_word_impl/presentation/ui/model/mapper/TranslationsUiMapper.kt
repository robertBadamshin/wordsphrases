package com.app.wordsphrases.add_word_impl.presentation.ui.model.mapper

import com.app.wordsphrases.add_word_impl.domain.entity.Translation
import com.app.wordsphrases.add_word_impl.presentation.ui.model.TranslationUiModel
import javax.inject.Inject

class TranslationsUiMapper @Inject constructor() {

    fun map(translations: List<Translation>): List<TranslationUiModel> {
        return translations.mapIndexed { index, translation ->
            val showDeleteButton = translations.size > 1 && index != translations.lastIndex

            TranslationUiModel(
                id = translation.id,
                text = translation.text,
                showDeleteButton = showDeleteButton,
            )
        }
    }
}