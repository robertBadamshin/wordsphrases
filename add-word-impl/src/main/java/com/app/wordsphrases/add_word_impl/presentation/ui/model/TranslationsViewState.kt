package com.app.wordsphrases.add_word_impl.presentation.ui.model

sealed class TranslationsViewState {

    data class Success(
        val translations: List<TranslationUiModel>,
    ) : TranslationsViewState()

    object Loading : TranslationsViewState()

    object Error : TranslationsViewState()

    object Empty : TranslationsViewState()
}