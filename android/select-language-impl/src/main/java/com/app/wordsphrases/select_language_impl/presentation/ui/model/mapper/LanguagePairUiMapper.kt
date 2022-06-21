package com.app.wordsphrases.select_language_impl.presentation.ui.model.mapper

import android.content.Context
import androidx.annotation.UiContext
import com.app.wordsphrases.select_language_impl.R
import com.app.wordsphrases.select_language_impl.domain.entity.SelectLanguagePairEnvironment
import com.app.wordsphrases.select_language_impl.presentation.ui.model.LanguagePairUiModel
import javax.inject.Inject

class LanguagePairUiMapper @Inject constructor(
    private val languageNameUiMapper: LanguageNameUiMapper,
    @UiContext private val context: Context,
) {

    fun map(environment: SelectLanguagePairEnvironment): LanguagePairUiModel {
        val learningLanguageText = if (environment.learningLanguage != null) {
            languageNameUiMapper.map(environment.learningLanguage)
        } else {
            context.getString(R.string.learning_language_title)
        }

        val nativeLanguageText = if (environment.nativeLanguage != null) {
            languageNameUiMapper.map(environment.nativeLanguage)
        } else {
            context.getString(R.string.native_language_title)
        }

        return LanguagePairUiModel(
            learningLanguageText = learningLanguageText,
            nativeLanguageText = nativeLanguageText
        )
    }
}