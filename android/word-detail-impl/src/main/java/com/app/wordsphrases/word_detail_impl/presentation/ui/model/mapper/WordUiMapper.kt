package com.app.wordsphrases.word_detail_impl.presentation.ui.model.mapper

import com.app.wordsphrases.word_detail_impl.presentation.ui.model.WordUiModel
import com.wordphrases.domain.entity.Word
import javax.inject.Inject

class WordUiMapper @Inject constructor() {

    fun map(word: Word): WordUiModel {
        val uiModel = WordUiModel(
            "Rus Eng",
            wordText = word.wordText,
            translations = word.translations,
            comment = word.comment,
        )

        return uiModel
    }
}