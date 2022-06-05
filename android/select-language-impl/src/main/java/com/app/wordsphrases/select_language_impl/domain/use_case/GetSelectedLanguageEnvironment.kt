package com.app.wordsphrases.select_language_impl.domain.use_case

import com.app.wordsphrases.select_language_impl.domain.entity.SelectLanguageEnvironment
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class GetSelectedLanguageEnvironment @Inject constructor(
    private val getSelectedLanguage: GetSelectedLanguage,
    private val getLanguages: GetLanguages,
) {

    operator fun invoke(): Flow<SelectLanguageEnvironment> {
        return combine(
            getSelectedLanguage(),
            getLanguages(),
        ) { selectedLanguage, languages ->
            return@combine SelectLanguageEnvironment(
                selectedLanguage = selectedLanguage,
                languages = languages
            )
        }
    }
}