package com.app.wordsphrases.add_word_impl.domain.use_case

import com.app.wordsphrases.add_word_impl.data.WordRepository
import javax.inject.Inject

class ValidateTranslations @Inject constructor(
    private val wordRepository: WordRepository,
) {

    operator fun invoke() {
        val translations = wordRepository.requireTranslations()

        val filteredTranslations = translations.filterIndexed { index, translation ->
            val isLast = translations.lastIndex == index
            if (!isLast && translation.text.isBlank()) {
                return@filterIndexed false
            }

            return@filterIndexed true
        }

        wordRepository.setTranslations(filteredTranslations)
    }
}