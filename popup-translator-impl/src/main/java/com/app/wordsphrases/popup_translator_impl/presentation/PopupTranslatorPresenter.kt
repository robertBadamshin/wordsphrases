package com.app.wordsphrases.popup_translator_impl.presentation

import com.app.wordsphrases.add_word_impl.domain.exception.TranslationsEmptyException
import com.app.wordsphrases.entity.RequestErrorStateWrapper
import com.app.wordsphrases.entity.RequestLoadingStateWrapper
import com.app.wordsphrases.entity.RequestSuccessStateWrapper
import com.app.wordsphrases.popup_translator_impl.R
import com.app.wordsphrases.popup_translator_impl.domain.use_case.GetTranslations
import com.app.wordsphrases.popup_translator_impl.domain.use_case.SetWordText
import com.app.wordsphrases.popup_translator_impl.domain.use_case.SubscribeForWordTranslation
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject

class PopupTranslatorPresenter @Inject constructor(
    private val setWordText: SetWordText,
    private val getTranslations: GetTranslations,
    private val subscribeForWordTranslation: SubscribeForWordTranslation,
) : MvpPresenter<PopupTranslatorView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        subscribeForTranslations()
        presenterScope.launch { subscribeForWordTranslation() }
    }

    private fun subscribeForTranslations() {
        getTranslations()
            .onEach { wrapper ->
                when (wrapper) {
                    is RequestSuccessStateWrapper -> {
                        viewState.hideTranslationProgress()
                        viewState.showTranslateButton()

                        val screen = selectTranslationStarter.getScreen()
                        router.navigateTo(screen)
                    }
                    is RequestErrorStateWrapper -> {
                        viewState.hideTranslationProgress()
                        viewState.showTranslateButton()

                        showErrorMessage(wrapper.throwable)
                    }
                    is RequestLoadingStateWrapper -> {
                        viewState.showTranslationProgress()
                        viewState.hideTranslateButton()
                    }
                }
            }
            .launchIn(presenterScope)
    }

    private fun showErrorMessage(throwable: Throwable) {
        val messageRes = when (throwable) {
            is TranslationsEmptyException -> R.string.are_not_able_to_translate
            else -> R.string.error_happened
        }
        viewState.showMessage(messageRes)
    }

    fun onSetWordText(text: String) {
        setWordText(text)
    }
}