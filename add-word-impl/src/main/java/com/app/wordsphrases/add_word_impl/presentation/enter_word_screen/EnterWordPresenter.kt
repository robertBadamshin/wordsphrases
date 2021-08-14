package com.app.wordsphrases.add_word_impl.presentation.enter_word_screen

import com.app.wordsphrases.add_word_impl.R
import com.app.wordsphrases.add_word_impl.domain.GetTranslations
import com.app.wordsphrases.add_word_impl.domain.SetWordText
import com.app.wordsphrases.add_word_impl.domain.SubscribeForWordTranslation
import com.app.wordsphrases.add_word_impl.domain.exception.TranslationsEmptyException
import com.app.wordsphrases.entity.RequestErrorStateWrapper
import com.app.wordsphrases.entity.RequestLoadingStateWrapper
import com.app.wordsphrases.entity.RequestSuccessStateWrapper
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject

class EnterWordPresenter @Inject constructor(
    private val setWordText: SetWordText,
    private val getTranslations: GetTranslations,
    private val subscribeForWordTranslation: SubscribeForWordTranslation,
) : MvpPresenter<EnterWordView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        subscribeForTranslations()
        subscribeForTranslation()
    }

    private fun subscribeForTranslations() {
        getTranslations()
            .onEach { wrapper ->
                when (wrapper) {
                    is RequestSuccessStateWrapper -> {
                        viewState.hideTranslationProgress()
                        viewState.showTranslateButton()

                        viewState.openTranslationScreen()
                    }
                    is RequestErrorStateWrapper -> {
                        viewState.hideTranslationProgress()
                        viewState.showTranslateButton()

                        showErrorMessage(wrapper)
                    }
                    is RequestLoadingStateWrapper -> {
                        viewState.showTranslationProgress()
                        viewState.hideTranslateButton()
                    }
                }
            }
            .launchIn(presenterScope)
    }

    private fun subscribeForTranslation() {
        presenterScope.launch {
            subscribeForWordTranslation()
        }
    }

    private fun showErrorMessage(wrapper: RequestErrorStateWrapper<List<String>>) {
        val messageRes = when (wrapper.throwable) {
            is TranslationsEmptyException -> R.string.are_not_able_to_translate
            else -> R.string.error_happened
        }
        viewState.showMessage(messageRes)
    }

    fun onTranslateClick(textToTranslate: String) {
        presenterScope.launch {
            setWordText(textToTranslate)
        }
    }

    fun onWordChanged(text: String) {
        viewState.hideTranslationProgress()

        if (text.isEmpty()) {
            viewState.setTranslateButtonDisabled()
        } else {
            viewState.setTranslateButtonEnabled()
        }
    }
}