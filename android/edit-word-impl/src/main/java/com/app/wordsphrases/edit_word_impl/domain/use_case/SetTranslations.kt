package com.app.wordsphrases.edit_word_impl.domain.use_case

import com.app.wordsphrases.edit_word_impl.data.EditWordRepository
import com.app.wordsphrases.edit_word_impl.domain.entity.Translation
import javax.inject.Inject

class SetTranslations @Inject constructor(
    private val editWordRepository: EditWordRepository,
) {

    operator fun invoke(translations: List<Translation>) {
        editWordRepository.setTranslations(translations)
    }
}