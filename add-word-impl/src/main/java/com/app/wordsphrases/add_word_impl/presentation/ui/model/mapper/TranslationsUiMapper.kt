package com.app.wordsphrases.add_word_impl.presentation.ui.model.mapper

import com.app.wordsphrases.add_word_impl.presentation.ui.model.TranslationUiModel
import com.app.wordsphrases.add_word_impl.presentation.ui.model.TranslationsViewState
import com.app.wordsphrases.entity.RequestErrorStateWrapper
import com.app.wordsphrases.entity.RequestLoadingStateWrapper
import com.app.wordsphrases.entity.RequestStateWrapper
import com.app.wordsphrases.entity.RequestSuccessStateWrapper
import javax.inject.Inject

class TranslationsUiMapper @Inject constructor() {

    fun map(wrapper: RequestStateWrapper<List<String>>?): TranslationsViewState {
        return when (wrapper) {
            is RequestSuccessStateWrapper -> mapSuccessState(wrapper.data)
            is RequestLoadingStateWrapper -> TranslationsViewState.Loading
            is RequestErrorStateWrapper -> TranslationsViewState.Error
            null -> TranslationsViewState.Empty
        }
    }

    private fun mapSuccessState(translations: List<String>): TranslationsViewState.Success {
        val translationsUiModels = translations.map { translation ->
            TranslationUiModel(
                text = translation
            )
        }

        return TranslationsViewState.Success(translationsUiModels)
    }
}