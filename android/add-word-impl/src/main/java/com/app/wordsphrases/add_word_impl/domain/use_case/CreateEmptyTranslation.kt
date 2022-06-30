package com.app.wordsphrases.add_word_impl.domain.use_case

import com.app.wordsphrases.add_word_impl.data.AddWordRepository
import com.app.wordsphrases.add_word_impl.domain.entity.Translation
import javax.inject.Inject

class CreateEmptyTranslation @Inject constructor(
    private val addWordRepository: AddWordRepository,
) {

    operator fun invoke() {
        val emptyTranslation = Translation(
            id = addWordRepository.getNextTranslationId(),
            text = "",
        )

        val translations = listOf(emptyTranslation)

        addWordRepository.setTranslations(translations)
    }
}