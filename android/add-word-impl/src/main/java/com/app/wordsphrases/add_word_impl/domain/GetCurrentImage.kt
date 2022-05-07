package com.app.wordsphrases.add_word_impl.domain

import com.app.wordsphrases.add_word_impl.data.WordRepository
import com.app.wordsphrases.add_word_api.WordImage
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCurrentImage @Inject constructor(
    private val wordRepository: WordRepository,
) {

    operator fun invoke(): WordImage? {
        return wordRepository.getCurrentImage()
    }
}