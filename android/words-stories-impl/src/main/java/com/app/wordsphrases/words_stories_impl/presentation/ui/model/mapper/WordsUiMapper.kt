package com.app.wordsphrases.words_stories_impl.presentation.ui.model.mapper

import com.app.wordsphrases.words_stories_impl.presentation.ui.model.WordUiModel
import com.wordphrases.domain.entity.Word
import javax.inject.Inject

class WordsUiMapper @Inject constructor() {

    fun map(words: List<Word>): List<WordUiModel> {
        return words.map { word ->
            WordUiModel(
                wordId = word.wordId,
                text = word.wordText,
                translations = word.translations,
                comment = word.comment,
            )
        }
    }
}