package com.app.wordsphrases.select_language_impl.presentation.ui.model.mapper

import android.content.Context
import androidx.annotation.UiContext
import com.app.wordsphrases.select_language_impl.R
import com.app.wordsphrases.select_language_impl.domain.entity.SelectLanguagePairEnvironment
import com.app.wordsphrases.select_language_impl.presentation.ui.model.*
import com.wordphrases.domain.entity.language.Language
import javax.inject.Inject

class LanguagePairUiMapper @Inject constructor(
    private val languageNameUiMapper: LanguageNameUiMapper,
    @UiContext private val context: Context,
) {

    fun map(environment: SelectLanguagePairEnvironment): LanguagePairUiModel {

        val learningLanguageTextToColor = if (environment.learningLanguage != null) {
            selectedLanguageModel(environment.learningLanguage)
        } else {
            val text = context.getString(R.string.learning_language_title)
            LanguageTextToColor(
                text = text,
                textType = LanguagePairTextType.Default,
            )
        }

        val nativeLanguageTextToColor = if (environment.nativeLanguage != null) {
            selectedLanguageModel(environment.nativeLanguage)
        } else {
            val text = context.getString(R.string.native_language_title)
            LanguageTextToColor(
                text = text,
                textType = LanguagePairTextType.Default,
            )
        }

        return LanguagePairUiModel(
            learningLanguageText = learningLanguageTextToColor.text,
            learningTextType = learningLanguageTextToColor.textType,
            nativeLanguageText = nativeLanguageTextToColor.text,
            nativeTextType = nativeLanguageTextToColor.textType,
        )
    }

    private fun selectedLanguageModel(language: Language): LanguageTextToColor {
        val languageName = languageNameUiMapper.map(language)

        return LanguageTextToColor(
            text = languageName,
            textType = LanguagePairTextType.Selected,
        )
    }

    private data class LanguageTextToColor(
        val text: String,
        val textType: LanguagePairTextType,
    )
}