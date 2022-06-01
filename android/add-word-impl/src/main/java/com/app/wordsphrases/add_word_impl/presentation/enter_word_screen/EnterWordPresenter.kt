package com.app.wordsphrases.add_word_impl.presentation.enter_word_screen

import com.app.wordsphrases.add_word_api.SelectTranslationStarter
import com.app.wordsphrases.add_word_api.domain.entity.*
import com.app.wordsphrases.add_word_impl.R
import com.app.wordsphrases.add_word_impl.di.AddWordNavigationQualifier
import com.app.wordsphrases.add_word_impl.domain.exception.TranslationsEmptyException
import com.app.wordsphrases.add_word_impl.domain.use_case.*
import com.app.wordsphrases.entity.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import moxy.*
import ru.terrakok.cicerone.Router
import java.util.*
import javax.inject.Inject

class EnterWordPresenter @Inject constructor(
    @AddWordNavigationQualifier private val router: Router,
    private val setWordText: SetWordText,
    private val getTranslations: GetTranslations,
    private val subscribeForWordTranslation: SubscribeForWordTranslation,
    private val selectTranslationStarter: SelectTranslationStarter,
    private val addWordComponentType: AddWordComponentType,
    private val uuid: UUID,
    private val initialTextWrapper: InitialTextWrapper,
    private val clearSelfAddWordComponent: ClearSelfAddWordComponent,
) : MvpPresenter<EnterWordView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        subscribeForTranslations()
        subscribeForTranslation()

        viewState.showKeyboard()

        when (addWordComponentType) {
            AddWordComponentType.Popup -> {
                val initialText = initialTextWrapper.text ?: "text should be presented"
                setWordText(initialText)
                viewState.setInitialText(initialText)
            }
            AddWordComponentType.Regular -> {
                // do nothing
            }
        }
    }

    private fun subscribeForTranslations() {
        getTranslations()
            .onEach { wrapper ->
                when (wrapper) {
                    is RequestSuccessStateWrapper -> {
                        viewState.hideTranslationProgress()
                        viewState.showTranslateButton()

                        val screen = selectTranslationStarter.getScreen(uuid)
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
        setWordText(textToTranslate)
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
        router.exit()
    }

    override fun onDestroy() {
        clearSelfAddWordComponent()
        super.onDestroy()
    }
}