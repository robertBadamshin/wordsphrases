package com.app.wordsphrases.add_word_impl.presentation.select_translation_fragment

import com.app.wordsphrases.add_word_api.WordImage
import com.app.wordsphrases.add_word_api.domain.entity.AddWordComponentType
import com.app.wordsphrases.add_word_impl.R
import com.app.wordsphrases.add_word_impl.di.AddWordNavigationQualifier
import com.app.wordsphrases.add_word_impl.domain.*
import com.app.wordsphrases.add_word_impl.presentation.ui.model.mapper.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import moxy.*
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class SelectTranslationPresenter @Inject constructor(
    @AddWordNavigationQualifier private val router: Router,
    private val getCurrentWordText: GetCurrentWordText,
    private val translationsUiMapper: TranslationsUiMapper,
    private val setImage: SetImage,
    private val onSaveWordClick: OnSaveWordClick,
    private val getSuccessfulTranslations: GetSuccessfulTranslations,
    private val getSelectedTranslationsIds: GetSelectedTranslationsIds,
    private val toggleTranslationSelection: ToggleTranslationSelection,
    private val autoSelectTranslations: AutoSelectTranslations,
    private val addWordComponentType: AddWordComponentType,
    private val wordTopMarginUiMapper: WordTopMarginUiMapper,
) : MvpPresenter<SelectTranslationView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        updateTranslations()
        updateWord()
        updateDoneButton()
        autoSelectTranslation()
        setWordTopMargin()
    }

    private fun setWordTopMargin() {
        val paddingUiModel = wordTopMarginUiMapper.map(addWordComponentType)
        viewState.setWordToMargin(paddingUiModel)
    }

    private fun autoSelectTranslation() {
        presenterScope.launch {
            autoSelectTranslations()
        }
    }

    private fun updateDoneButton() {
        getSelectedTranslationsIds()
            .onEach { ids ->
                if (ids.isNotEmpty()) {
                    viewState.setDoneButtonEnabled()
                } else {
                    viewState.setDoneButtonDisabled()
                }
            }
            .launchIn(presenterScope)
    }

    private fun updateWord() {
        presenterScope.launch {
            val wordText = getCurrentWordText()
            viewState.setWordText(wordText)
        }
    }

    private fun updateTranslations() {
        combine(
            getSuccessfulTranslations(),
            getSelectedTranslationsIds(),
        ) { translations, ids ->
            translationsUiMapper.map(translations = translations, selectedIds = ids)
        }
            .onEach { uiModels -> viewState.showTranslations(uiModels) }
            .launchIn(presenterScope)
    }

    fun onImageSelected(image: WordImage) {
        setImage(image)
    }

    fun onAddWordClicked() {
        presenterScope.launch {
            onSaveWordClick()
            viewState.showToastMessage(R.string.word_added)
            router.newRootChain()
        }
    }

    fun onToggleTranslationSelection(id: Int) {
        toggleTranslationSelection(id = id)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}