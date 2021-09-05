package com.app.wordsphrases.add_word_impl.presentation.add_word_screen

import com.app.wordsphrases.add_word_api.WordImage
import com.app.wordsphrases.add_word_impl.di.AddWordComponent
import com.app.wordsphrases.add_word_impl.domain.AutoSelectTranslations
import com.app.wordsphrases.add_word_impl.domain.GetAddWordResult
import com.app.wordsphrases.add_word_impl.domain.GetCurrentWordText
import com.app.wordsphrases.add_word_impl.domain.GetImage
import com.app.wordsphrases.add_word_impl.domain.GetSelectedTranslationsIds
import com.app.wordsphrases.add_word_impl.domain.GetSuccessfulTranslations
import com.app.wordsphrases.add_word_impl.domain.OnSaveWordClick
import com.app.wordsphrases.add_word_impl.domain.SetImage
import com.app.wordsphrases.add_word_impl.domain.ToggleTranslationSelection
import com.app.wordsphrases.add_word_impl.presentation.ui.model.mapper.TranslationsUiMapper
import com.app.wordsphrases.stories_api.StoriesNavigationQualifier
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.presenterScope
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class SelectTranslationPresenter @Inject constructor(
    private val getCurrentWordText: GetCurrentWordText,
    private val translationsUiMapper: TranslationsUiMapper,
    private val setImage: SetImage,
    // TODO cut out image
    private val getImage: GetImage,
    private val getAddWordResult: GetAddWordResult,
    private val onSaveWordClick: OnSaveWordClick,
    @StoriesNavigationQualifier private val router: Router,
    private val getSuccessfulTranslations: GetSuccessfulTranslations,
    private val getSelectedTranslationsIds: GetSelectedTranslationsIds,
    private val toggleTranslationSelection: ToggleTranslationSelection,
    private val autoSelectTranslations: AutoSelectTranslations,
) : MvpPresenter<SelectTranslationView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        updateTranslations()
        updateWord()
        updateDoneButton()
        autoSelectTranslation()
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
            AddWordComponent.clear()
            router.newRootChain()
        }
    }

    fun onToggleTranslationSelection(id: Int) {
        toggleTranslationSelection(id = id)
    }
}