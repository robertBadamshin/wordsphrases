package com.app.wordsphrases.dictionary_impl.presentation

import com.app.wordsphrases.dictionary_impl.presentation.ui.mapper.WordUiMapper
import com.wordphrases.domain.entity.WordId
import com.wordphrases.domain.usecase.GetAllWordsForDictionary
import com.wordphrases.domain.usecase.language_pair.GetSelectedLanguagePair
import kotlinx.coroutines.flow.*
import moxy.*
import javax.inject.Inject

class DictionaryPresenter @Inject constructor(
    private val wordUiMapper: WordUiMapper,
    private val getAllWordsForDictionary: GetAllWordsForDictionary,
    private val getSelectedLanguagePair: GetSelectedLanguagePair,
) : MvpPresenter<DictionaryView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        updateWords()
    }

    private fun updateWords() {
        getSelectedLanguagePair()
            .flatMapLatest { languagePair -> getAllWordsForDictionary(languagePair.pairId) }
            .map { words -> wordUiMapper.map(words) }
            .onEach { uiModels -> viewState.setWords(uiModels) }
            .launchIn(presenterScope)
    }

    fun onWordClick(wordId: WordId) {
        // open word edit
    }
}