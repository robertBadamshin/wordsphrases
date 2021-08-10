package com.app.wordsphrases.add_word_impl.domain

import com.app.wordsphrases.add_word_impl.data.WordRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import javax.inject.Inject

class RequireSelectedTranslation @Inject constructor(
    private val wordRepository: WordRepository,
) {

    operator fun invoke(): String {
        return wordRepository.requireSelectedTranslation()
    }
}