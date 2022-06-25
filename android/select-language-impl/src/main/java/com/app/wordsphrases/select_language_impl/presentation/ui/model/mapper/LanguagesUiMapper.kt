package com.app.wordsphrases.select_language_impl.presentation.ui.model.mapper

import com.app.wordsphrases.select_language_impl.presentation.ui.model.LanguageUiModel
import com.wordphrases.domain.entity.language.Language
import javax.inject.Inject

class LanguagesUiMapper @Inject constructor(
    private val languageNameUiMapper: LanguageNameUiMapper,
) {

    fun map(languages: List<Language>): List<LanguageUiModel> {
        return languages.map { language ->
            val languageName = languageNameUiMapper.map(language)

            LanguageUiModel(
                name = languageName,
                language = language,
            )
        }
    }
}