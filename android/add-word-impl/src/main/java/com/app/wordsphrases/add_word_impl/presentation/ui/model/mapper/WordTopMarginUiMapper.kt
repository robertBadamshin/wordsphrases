package com.app.wordsphrases.add_word_impl.presentation.ui.model.mapper

import com.app.wordsphrases.add_word_api.domain.entity.AddWordComponentType
import com.app.wordsphrases.add_word_impl.presentation.ui.model.MarginUiModel
import javax.inject.Inject

class WordTopMarginUiMapper @Inject constructor() {

    fun map(addWordComponentType: AddWordComponentType): MarginUiModel {
        return when (addWordComponentType) {
            AddWordComponentType.Regular -> MarginUiModel(44)
            AddWordComponentType.Popup -> MarginUiModel(22)
        }
    }
}