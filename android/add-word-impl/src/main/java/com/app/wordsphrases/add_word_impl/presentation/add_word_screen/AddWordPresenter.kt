package com.app.wordsphrases.add_word_impl.presentation.add_word_screen

import com.app.wordsphrases.add_word_api.domain.entity.*
import com.app.wordsphrases.add_word_impl.di.AddWordNavigationQualifier
import com.app.wordsphrases.add_word_impl.domain.use_case.*
import com.app.wordsphrases.add_word_impl.presentation.ui.model.mapper.TranslationsUiMapper
import kotlinx.coroutines.flow.*
import moxy.*
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class AddWordPresenter @Inject constructor(
    @AddWordNavigationQualifier private val router: Router,
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

    fun onAddWordClick(wordText: String, comment: String?) {
//        val word = Word()
//        setWordText(wordText)
    }

    fun onWordChanged(text: String) {
        if (text.isEmpty()) {
            viewState.setAddWordButtonDisabled()
        } else {
            viewState.setAddWordButtonEnabled()
        }
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
    }

    fun onRemoveTranslationClick(translationId: Int) {
        removeTranslation(translationId)
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