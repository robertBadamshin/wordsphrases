package com.app.wordsphrases.add_word_impl.presentation.enter_word_screen

import com.app.wordsphrases.add_word_api.SelectTranslationStarter
import com.app.wordsphrases.add_word_api.di.AddWordNavigationQualifier
import com.app.wordsphrases.add_word_api.domain.entity.AddWordComponentType
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
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class EnterWordPresenter @Inject constructor(
    @AddWordNavigationQualifier private val router: Router,
    private val setWordText: SetWordText,
    private val getTranslations: GetTranslations,
    private val subscribeForWordTranslation: SubscribeForWordTranslation,
    private val selectTranslationStarter: SelectTranslationStarter,
    private val addWordComponentType: AddWordComponentType,
) : MvpPresenter<EnterWordView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        subscribeForTranslations()
        subscribeForTranslation()

        viewState.showKeyboard()
    }

    private fun subscribeForTranslations() {
        getTranslations()
            .onEach { wrapper ->
                when (wrapper) {
                    is RequestSuccessStateWrapper -> {
                        viewState.hideTranslationProgress()
                        viewState.showTranslateButton()

                        val screen = selectTranslationStarter.getScreen(addWordComponentType)
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

    private fun subscribeForTranslation() {
        presenterScope.launch {
            subscribeForWordTranslation()
        }
    }

    private fun showErrorMessage(throwable: Throwable) {
        val messageRes = when (throwable) {
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

    fun showKeyboard() {
        viewState.showKeyboard()
    }

    fun onBackPressed() {
        //AddWordComponent.clear()
        router.exit()
    }
}