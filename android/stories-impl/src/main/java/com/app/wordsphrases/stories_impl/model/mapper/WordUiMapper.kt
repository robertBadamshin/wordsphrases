package com.app.wordsphrases.stories_impl.model.mapper

import com.app.wordsphrases.entity.word.WordOld
import com.app.wordsphrases.stories_impl.model.WordUiModel
import javax.inject.Inject

class WordUiMapper @Inject constructor() {

    fun map(word: WordOld): WordUiModel {
        val translationText = word.translations.joinToString(separator = ", ")

        return WordUiModel(
            word = word.word,
            translation = translationText,
        )
    }
}