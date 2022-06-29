package com.app.wordsphrases.add_word_impl.presentation.add_word_screen

import com.app.wordsphrases.add_word_api.domain.entity.*
import com.app.wordsphrases.add_word_impl.R
import com.app.wordsphrases.add_word_impl.domain.use_case.*
import com.app.wordsphrases.add_word_impl.presentation.ui.model.mapper.TranslationsUiMapper
import com.app.wordsphrases.core.di.MainNavigationQualifier
import kotlinx.coroutines.flow.*
import moxy.*
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class AddWordPresenter @Inject constructor(
    private val setWordText: SetWordText,
    private val addWordComponentType: AddWordComponentType,
    private val initialTextWrapper: InitialTextWrapper,
    private val clearSelfAddWordComponent: ClearSelfAddWordComponent,
    private val getTranslations: GetTranslations,
    private val translationsUiMapper: TranslationsUiMapper,
    private val manageEmptyTranslation: ManageEmptyTranslation,
    private val updateTranslation: UpdateTranslation,
    private val createEmptyTranslation: CreateEmptyTranslation,
    private val removeTranslation: RemoveTranslation,
    private val setCommentText: SetCommentText,
    private val isWordValid: IsWordValid,
    private val onSaveWord: OnSaveWord,
    @MainNavigationQualifier private val router: Router,
) : MvpPresenter<AddWordView>() {

    private var focusedTranslation: Int? = null

    private fun requireFocusedTranslation(): Int {
        return focusedTranslation
            ?: throw IllegalStateException("focusedTranslation should be not null")
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

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

        createEmptyTranslation()
        updateTranslations()
    }

    private fun updateTranslations() {
        getTranslations()
            .mapLatest { translations -> translationsUiMapper.map(translations = translations) }
            .onEach { uiModels -> viewState.showTranslations(uiModels) }
            .launchIn(presenterScope)
    }

    fun onAddWordClick() {
        onSaveWord()
        viewState.showToastMessage(R.string.word_added)
        router.newRootChain()
    }

    fun onWordChanged(text: String) {
        setWordText(text)
        validateAddWordButtonState()
    }

    private fun validateAddWordButtonState() {
        val wordValid = isWordValid()
        if (wordValid) {
            viewState.setAddWordButtonEnabled()
        } else {
            viewState.setAddWordButtonDisabled()
        }
    }

    fun onCommentChanged(text: String) {
        setCommentText(text)
    }

    fun onLostTranslateFocus() {
        this.focusedTranslation = null
    }

    fun onFindTranslateFocus(translationId: Int) {
        this.focusedTranslation = translationId
    }

    fun onInputTranslate(text: String) {
        val translationId = requireFocusedTranslation()
        updateTranslation(translationId, text)
        manageEmptyTranslation()
        validateAddWordButtonState()
    }

    fun onRemoveTranslationClick(translationId: Int) {
        removeTranslation(translationId)
        validateAddWordButtonState()
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