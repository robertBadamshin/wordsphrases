package com.app.wordsphrases.add_word_impl.domain.use_case

import com.app.wordsphrases.add_word_impl.data.WordRepository
import com.app.wordsphrases.add_word_impl.domain.entity.Translation
import javax.inject.Inject

class SetTranslations @Inject constructor(
    private val wordRepository: WordRepository,
) {

    operator fun invoke(translations: List<Translation>) {
        wordRepository.setTranslations(translations)
    }
}