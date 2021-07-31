package com.app.wordsphrases.add_word_impl.presentation

import com.app.wordsphrases.add_word_impl.domain.AddWord
import com.app.wordsphrases.add_word_impl.domain.GetAddWordResult
import com.app.wordsphrases.add_word_impl.domain.GetImage
import com.app.wordsphrases.add_word_impl.domain.GetTranslations
import com.app.wordsphrases.add_word_impl.domain.OnTranslateTextClick
import com.app.wordsphrases.add_word_impl.domain.SetImage
import com.app.wordsphrases.add_word_impl.domain.entity.WordImage
import com.app.wordsphrases.add_word_impl.presentation.ui.model.mapper.TranslationsUiMapper
import com.app.wordsphrases.entity.RequestErrorStateWrapper
import com.app.wordsphrases.entity.RequestLoadingStateWrapper
import com.app.wordsphrases.entity.RequestSuccessStateWrapper
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject

class AddWordPresenter @Inject constructor(
    private val getTranslations: GetTranslations,
    private val onTranslateTextClick: OnTranslateTextClick,
    private val translationsUiMapper: TranslationsUiMapper,
    private val setImage: SetImage,
    private val getImage: GetImage,
    private val getAddWordResult: GetAddWordResult,
    private val addWord: AddWord,
) : MvpPresenter<AddWordView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        getTranslations()
            .map { wrapper -> translationsUiMapper.map(wrapper) }
            .onEach { state -> viewState.showTranslations(state) }
            .launchIn(presenterScope)

        getImage()
            .onEach { image -> viewState.setImage(image) }
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
    }

    fun onTranslateClick(textToTranslate: String?) {
        presenterScope.launch {
            if (textToTranslate.isNullOrEmpty()) {
                return@launch
            }

            onTranslateTextClick(textToTranslate)
        }
    }

    fun onImageSelected(image: WordImage) {
        setImage(image)
    }

    fun onAddWordClicked(text: String, translation: String) {
        presenterScope.launch {
            addWord(text = text, translation = translation)
        }
    }
}