package com.app.wordsphrases.edit_word_impl.domain.use_case

import com.app.wordsphrases.edit_word_impl.data.EditWordRepository
import com.app.wordsphrases.edit_word_impl.domain.entity.Translation
import com.wordphrases.domain.entity.Word
import javax.inject.Inject

class FillTranslationsFromWord @Inject constructor(
    private val editWordRepository: EditWordRepository,
) {

    operator fun invoke(word: Word) {
        val translations = word.translations.map { translation ->
            val translationId = editWordRepository.getNextTranslationId()

            Translation(
                id = translationId,
                text = translation,
            )
        }

        editWordRepository.setTranslations(translations)
    }
}