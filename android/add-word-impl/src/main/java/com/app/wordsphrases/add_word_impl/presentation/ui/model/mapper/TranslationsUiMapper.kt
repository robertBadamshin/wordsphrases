package com.app.wordsphrases.add_word_impl.presentation.ui.model.mapper

import com.app.wordsphrases.add_word_impl.presentation.ui.model.TranslationUiModel
import com.app.wordsphrases.translation_api.domain.Translation
import javax.inject.Inject

class TranslationsUiMapper @Inject constructor() {

    fun map(
        translations: List<Translation>,
        selectedIds: Set<Int>,
    ): List<TranslationUiModel> {
        return translations.map { translation ->
            val selected = selectedIds.contains(translation.id)

            TranslationUiModel(
                id = translation.id,
                text = translation.text,
                selected = selected,
            )
        }
    }
}