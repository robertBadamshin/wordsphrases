package com.app.wordsphrases.add_word_impl.presentation.add_word_screen

import com.app.wordsphrases.add_word_api.WordImage
import com.app.wordsphrases.add_word_impl.domain.GetAddWordResult
import com.app.wordsphrases.add_word_impl.domain.GetCurrentWordText
import com.app.wordsphrases.add_word_impl.domain.GetImage
import com.app.wordsphrases.add_word_impl.domain.GetSelectedTranslationsIds
import com.app.wordsphrases.add_word_impl.domain.GetTranslations
import com.app.wordsphrases.add_word_impl.domain.OnSaveWordClick
import com.app.wordsphrases.add_word_impl.domain.GetSuccessfulTranslations
import com.app.wordsphrases.add_word_impl.domain.SetWordText
import com.app.wordsphrases.add_word_impl.domain.SetImage
import com.app.wordsphrases.add_word_impl.domain.ToggleTranslationSelection
import com.app.wordsphrases.add_word_impl.presentation.ui.model.mapper.TranslationsUiMapper
import com.app.wordsphrases.entity.RequestErrorStateWrapper
import com.app.wordsphrases.entity.RequestLoadingStateWrapper
import com.app.wordsphrases.entity.RequestSuccessStateWrapper
import com.app.wordsphrases.translation_api.domain.Translation
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
    private val router: Router,
    private val getSuccessfulTranslations: GetSuccessfulTranslations,
    private val getSelectedTranslationsIds: GetSelectedTranslationsIds,
    private val toggleTranslationSelection: ToggleTranslationSelection,
) : MvpPresenter<AddWordView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        combine(
            getSuccessfulTranslations(),
            getSelectedTranslationsIds(),
        ) { translations, ids ->
            translationsUiMapper.map(translations = translations, selectedIds = ids)
        }
            .onEach { uiModels -> viewState.showTranslations(uiModels) }
            .launchIn(presenterScope)

        getAddWordResult()
            .onEach { wrapper ->
                when (wrapper) {
                    is RequestSuccessStateWrapper -> {
                        viewState.showMessage("Success")
                        // TODO add routing
                    }
                    is RequestErrorStateWrapper -> {
                        viewState.showMessage("Error")
                    }
                    is RequestLoadingStateWrapper -> {
                        // TODO nothing
                    }
                }
            }
            .launchIn(presenterScope)

        presenterScope.launch {
            val wordText = getCurrentWordText()
            viewState.setWordText(wordText)
        }
    }

    fun onImageSelected(image: WordImage) {
        setImage(image)
    }

    fun onAddWordClicked() {
        presenterScope.launch {
            onSaveWordClick()
            router.backTo(null)
        }
    }

    fun onToggleTranslationSelection(id: Int) {
        toggleTranslationSelection(id = id)
    }
}