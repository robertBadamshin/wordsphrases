package com.app.wordsphrases.add_word_impl.domain.use_case

import com.app.wordsphrases.add_word_impl.data.AddWordRepository
import javax.inject.Inject

class SetWordText @Inject constructor(
    private val addWordRepository: AddWordRepository,
) {

    operator fun invoke(text: String) {
        addWordRepository.setWordText(text)
    }
}