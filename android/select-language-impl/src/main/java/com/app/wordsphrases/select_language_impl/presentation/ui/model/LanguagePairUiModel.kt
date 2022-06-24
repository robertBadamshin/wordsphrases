package com.app.wordsphrases.select_language_impl.presentation.ui.model

data class LanguagePairUiModel(
    val learningLanguageText: String,
    val learningTextType: LanguagePairTextType,
    val nativeLanguageText: String,
    val nativeTextType: LanguagePairTextType,
)