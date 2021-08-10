package com.app.wordsphrases.add_word_impl.domain

import com.app.wordsphrases.add_word_impl.data.WordRepository
import javax.inject.Inject

class SetSelectedTranslation @Inject constructor(
    private val wordRepository: WordRepository,
) {

    operator fun invoke(translation: String) {
        wordRepository.setSelectedTranslation(translation)
    }
}