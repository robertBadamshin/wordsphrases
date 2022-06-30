package com.app.wordsphrases.add_word_impl.domain.use_case

import com.app.wordsphrases.add_word_impl.data.AddWordRepository
import javax.inject.Inject

class RemoveTranslation @Inject constructor(
    private val addWordRepository: AddWordRepository,
) {

    operator fun invoke(translationId: Int) {
        val translations = addWordRepository.requireTranslations().toMutableList()

        val filteredTranslations = translations
            .filter { translation -> translation.id != translationId }

        addWordRepository.setTranslations(filteredTranslations)
    }
}