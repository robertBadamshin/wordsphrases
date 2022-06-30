package com.app.wordsphrases.add_word_impl.domain.use_case

import com.app.wordsphrases.add_word_impl.data.AddWordRepository
import kotlinx.coroutines.flow.filter
import javax.inject.Inject

class AutoSelectTranslations @Inject constructor(
    private val getSuccessfulTranslations: GetSuccessfulTranslations,
    private val addWordRepository: AddWordRepository,
) {

    suspend operator fun invoke() {
        return getSuccessfulTranslations()
            .filter { translations -> translations.size == 1 }
            .collect { translations ->
                val translation = translations.first()
                addWordRepository.setSelectedTranslationsIds(setOf(translation.id))
            }
    }
}