package com.app.wordsphrases.add_word_impl.domain

import com.app.wordsphrases.add_word_impl.data.WordRepository
import javax.inject.Inject

class GetCurrentWordText @Inject constructor(
    private val wordRepository: WordRepository,
) {

    operator fun invoke(): String {
        return wordRepository.getCurrentWordText()
    }
}