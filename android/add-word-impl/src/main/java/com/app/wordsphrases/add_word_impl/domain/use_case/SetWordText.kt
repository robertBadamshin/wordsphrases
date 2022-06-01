package com.app.wordsphrases.add_word_impl.domain.use_case

import com.app.wordsphrases.add_word_impl.data.WordRepository
import javax.inject.Inject

class SetWordText @Inject constructor(
    private val wordRepository: WordRepository,
) {

    operator fun invoke(text: String) {
        wordRepository.setWordText(text)
    }
}