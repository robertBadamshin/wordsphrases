package com.app.wordsphrases.add_word_impl.domain.use_case

import com.app.wordsphrases.add_word_api.WordImage
import com.app.wordsphrases.add_word_impl.data.AddWordRepository
import javax.inject.Inject

class GetCurrentImage @Inject constructor(
    private val addWordRepository: AddWordRepository,
) {

    operator fun invoke(): WordImage? {
        return addWordRepository.getCurrentImage()
    }
}