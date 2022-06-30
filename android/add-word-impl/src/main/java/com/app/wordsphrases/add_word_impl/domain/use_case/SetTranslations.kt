package com.app.wordsphrases.add_word_impl.domain.use_case

import com.app.wordsphrases.add_word_impl.data.AddWordRepository
import com.app.wordsphrases.add_word_impl.domain.entity.Translation
import javax.inject.Inject

class SetTranslations @Inject constructor(
    private val addWordRepository: AddWordRepository,
) {

    operator fun invoke(translations: List<Translation>) {
        addWordRepository.setTranslations(translations)
    }
}