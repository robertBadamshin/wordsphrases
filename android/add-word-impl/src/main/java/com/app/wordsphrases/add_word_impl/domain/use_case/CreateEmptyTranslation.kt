package com.app.wordsphrases.add_word_impl.domain.use_case

import com.app.wordsphrases.add_word_impl.data.WordRepository
import com.app.wordsphrases.add_word_impl.domain.entity.Translation
import javax.inject.Inject

class CreateEmptyTranslation @Inject constructor(
    private val wordRepository: WordRepository,
) {

    operator fun invoke() {
        val emptyTranslation = Translation(
            id = wordRepository.getNextTranslationId(),
            text = "",
        )

        val translations = listOf(emptyTranslation)

        wordRepository.setTranslations(translations)
    }
}