package com.app.wordsphrases.dictionary_impl.presentation.ui.mapper

import com.app.wordsphrases.dictionary_impl.presentation.ui.WordUiModel
import com.wordphrases.domain.entity.Word
import javax.inject.Inject

class WordUiMapper @Inject constructor() {

    fun map(words: List<Word>): List<WordUiModel> {
        return words.map { word ->
            val translationsText = word.translations.reduce { acc, value -> "$acc, $value" }

            WordUiModel(
                wordId = word.wordId,
                wordText = word.wordText,
                translationsText = translationsText,
            )
        }
    }
}