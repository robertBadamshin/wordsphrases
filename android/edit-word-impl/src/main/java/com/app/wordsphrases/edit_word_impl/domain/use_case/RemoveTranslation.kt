package com.app.wordsphrases.edit_word_impl.domain.use_case

import com.app.wordsphrases.edit_word_impl.data.EditWordRepository
import javax.inject.Inject

class RemoveTranslation @Inject constructor(
    private val editWordRepository: EditWordRepository,
) {

    operator fun invoke(translationId: Int) {
        val translations = editWordRepository.requireTranslations().toMutableList()

        val filteredTranslations = translations
            .filter { translation -> translation.id != translationId }

        editWordRepository.setTranslations(filteredTranslations)
    }
}