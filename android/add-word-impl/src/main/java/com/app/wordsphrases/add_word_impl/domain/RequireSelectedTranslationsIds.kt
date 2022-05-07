package com.app.wordsphrases.add_word_impl.domain

import com.app.wordsphrases.add_word_impl.data.WordRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RequireSelectedTranslationsIds @Inject constructor(
    private val wordRepository: WordRepository,
) {

    operator fun invoke(): Set<Int> {
        return wordRepository.requireSelectedTranslationsIds()
    }
}