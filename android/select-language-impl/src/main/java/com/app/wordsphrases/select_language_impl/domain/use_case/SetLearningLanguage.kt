package com.app.wordsphrases.select_language_impl.domain.use_case

import com.app.wordsphrases.select_language_impl.data.LanguagePairRepository
import com.wordphrases.domain.entity.language.Language
import javax.inject.Inject

class SetLearningLanguage @Inject constructor(
    private val languagePairRepository: LanguagePairRepository,
) {

    operator fun invoke(language: Language) {
        languagePairRepository.setLearningLanguage(language)
    }
}
