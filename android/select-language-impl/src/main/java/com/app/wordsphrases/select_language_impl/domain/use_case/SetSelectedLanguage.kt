package com.app.wordsphrases.select_language_impl.domain.use_case

import com.app.wordsphrases.select_language_impl.data.SelectLanguageRepository
import com.wordphrases.domain.entity.language.Language
import javax.inject.Inject

class SetSelectedLanguage @Inject constructor(
    private val selectLanguageRepository: SelectLanguageRepository,
) {

    operator fun invoke(language: Language) {
        selectLanguageRepository.setSelectedLanguage(language)
    }
}