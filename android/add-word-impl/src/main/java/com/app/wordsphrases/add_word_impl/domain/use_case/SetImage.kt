package com.app.wordsphrases.add_word_impl.domain.use_case

import com.app.wordsphrases.add_word_api.WordImage
import com.app.wordsphrases.add_word_impl.data.WordRepository
import javax.inject.Inject

class SetImage @Inject constructor(
    private val wordRepository: WordRepository,
) {

    operator fun invoke(image: WordImage?) {
        wordRepository.setImage(image)
    }
}