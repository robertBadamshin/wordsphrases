package com.app.wordsphrases.add_word_impl.domain

import com.app.wordsphrases.add_word_impl.data.WordRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import javax.inject.Inject

class AutoSelectTranslations @Inject constructor(
    private val getSuccessfulTranslations: GetSuccessfulTranslations,
    private val wordRepository: WordRepository,
) {

    suspend operator fun invoke() {
        return getSuccessfulTranslations()
            .filter { translations -> translations.size == 1 }
            .collect { translations ->
                val translation = translations.first()
                wordRepository.setSelectedTranslationsIds(setOf(translation.id))
            }
    }
}