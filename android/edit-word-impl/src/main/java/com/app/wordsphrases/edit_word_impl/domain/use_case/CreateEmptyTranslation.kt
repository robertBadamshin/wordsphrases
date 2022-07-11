package com.app.wordsphrases.edit_word_impl.domain.use_case

import com.app.wordsphrases.edit_word_impl.data.EditWordRepository
import com.app.wordsphrases.edit_word_impl.domain.entity.Translation
import javax.inject.Inject

class CreateEmptyTranslation @Inject constructor(
    private val editWordRepository: EditWordRepository,
) {

    operator fun invoke() {
        val emptyTranslation = Translation(
            id = editWordRepository.getNextTranslationId(),
            text = "",
        )

        val translations = listOf(emptyTranslation)

        editWordRepository.setTranslations(translations)
    }
}