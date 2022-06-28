package com.app.wordsphrases.add_word_impl.domain.use_case

import com.app.wordsphrases.add_word_impl.data.WordRepository
import javax.inject.Inject

class RemoveTranslation @Inject constructor(
    private val wordRepository: WordRepository,
) {

    operator fun invoke(translationId: Int) {
        val translations = wordRepository.requireTranslations().toMutableList()

        val filteredTranslations = translations
            .filter { translation -> translation.id != translationId }

        wordRepository.setTranslations(filteredTranslations)
    }
}