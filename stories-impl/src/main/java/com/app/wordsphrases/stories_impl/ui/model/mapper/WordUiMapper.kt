package com.app.wordsphrases.stories_impl.ui.model.mapper

import com.app.wordsphrases.entity.word.Word
import com.app.wordsphrases.stories_impl.ui.model.WordUiModel
import javax.inject.Inject

class WordUiMapper @Inject constructor() {

    fun map(word: Word): WordUiModel {
        return WordUiModel(
            word = word.word,
            translation = word.translation,
        )
    }
}