package com.app.wordsphrases.edit_word_impl.presentation.add_word_screen

import com.app.wordsphrases.edit_word_api.domain.entity.EditWordType
import com.app.wordsphrases.edit_word_impl.R
import com.app.wordsphrases.edit_word_impl.domain.use_case.*
import com.app.wordsphrases.edit_word_impl.presentation.ui.model.mapper.TranslationsUiMapper
import com.app.wordsphrases.core.di.MainNavigationQualifier
import com.wordphrases.domain.usecase.word.GetWordById
import kotlinx.coroutines.flow.*
import moxy.*
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class EditWordPresenter @Inject constructor(
    private val setWordText: SetWordText,
    private val editWordType: EditWordType,
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
    private val getWordById: GetWordById,
    private val fillTranslationsFromWord: FillTranslationsFromWord,
    private val setExistingWord: SetExistingWord,
) : MvpPresenter<EditWordView>() {

    private var focusedTranslation: Int? = null

    private fun requireFocusedTranslation(): Int {
        return focusedTranslation
            ?: throw IllegalStateException("focusedTranslation should be not null")
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.showKeyboard()

        when (editWordType) {
            is EditWordType.EditWord -> {
                val wordId = editWordType.wordId
                val word = getWordById(wordId)

                setExistingWord(word)

                setWordText(word.wordText)
                viewState.setInitialText(word.wordText)

                setCommentText(word.comment)
                viewState.setCommentText(word.comment)

                fillTranslationsFromWord(word)

                validateAddWordButtonState()
            }
            is EditWordType.AddWord -> {
                createEmptyTranslation()
            }
        }

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
}