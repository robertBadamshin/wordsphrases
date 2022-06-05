package com.app.wordsphrases.select_language_impl.presentation.ui.model.mapper

import android.content.Context
import androidx.annotation.UiContext
import com.app.wordsphrases.select_language_impl.R
import com.app.wordsphrases.select_language_impl.domain.entity.SelectLanguageEnvironment
import com.app.wordsphrases.select_language_impl.presentation.ui.model.LanguageUiModel
import com.wordphrases.domain.entity.language.Language
import javax.inject.Inject

class LanguagesUiMapper @Inject constructor(
    @UiContext private val context: Context,
) {

    fun map(selectLanguageEnvironment: SelectLanguageEnvironment): List<LanguageUiModel> {
        return selectLanguageEnvironment.languages.map { language ->
            val languageNameRes = when (language) {
                Language.Arabic -> R.string.arabic_language
                Language.German -> R.string.german_language
                Language.Portuguese -> R.string.portuguese_language
                Language.Japanese -> R.string.japanese_language
                Language.Chinese -> R.string.chinese_language
                Language.English -> R.string.english_language
                Language.Estonian -> R.string.estonian_language
                Language.French -> R.string.french_language
                Language.Italian -> R.string.italian_language
                Language.Russian -> R.string.russian_language
                Language.Spanish -> R.string.spanish_language
                Language.Turkish -> R.string.turkish_language
            }

            val languageName = context.getString(languageNameRes)
            val selected = language == selectLanguageEnvironment.selectedLanguage

            LanguageUiModel(
                name = languageName,
                language = language,
                selected = selected,
            )
        }
    }
}