package com.app.wordsphrases.add_word_impl.presentation

import com.app.wordsphrases.add_word_impl.domain.GetTranslations
import com.app.wordsphrases.add_word_impl.domain.OnTranslateTextClick
import com.app.wordsphrases.add_word_impl.presentation.ui.model.mapper.TranslationsUiMapper
import com.app.wordsphrases.translation_api.TranslateText
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject

class AddWordPresenter @Inject constructor(
    private val getTranslations: GetTranslations,
    private val onTranslateTextClick: OnTranslateTextClick,
    private val translationsUiMapper: TranslationsUiMapper,
) : MvpPresenter<AddWordView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        getTranslations()
            .map { wrapper -> translationsUiMapper.map(wrapper) }
            .onEach { state -> viewState.showTranslations(state) }
            .launchIn(presenterScope)
    }

    fun onTranslateClick(textToTranslate: String?) {
        presenterScope.launch {
            if (textToTranslate.isNullOrEmpty()) {
                return@launch
            }

            onTranslateTextClick(textToTranslate)
        }
    }
}