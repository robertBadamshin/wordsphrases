package com.app.wordsphrases.words_stories_impl.presentation

import com.app.wordsphrases.words_stories_impl.presentation.ui.model.mapper.WordsUiMapper
import com.wordphrases.domain.usecase.GetAllWordsForDictionary
import com.wordphrases.domain.usecase.language_pair.RequireSelectedLanguagePair
import kotlinx.coroutines.flow.*
import moxy.*
import javax.inject.Inject

class WordStoriesPresenter @Inject constructor(
    private val wordsUiMapper: WordsUiMapper,
    private val getAllWordsForDictionary: GetAllWordsForDictionary,
    private val requireSelectedLanguagePair: RequireSelectedLanguagePair,
) : MvpPresenter<WordStoriesView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        updateWords()
    }

    private fun updateWords() {
        val languagePair = requireSelectedLanguagePair()
        getAllWordsForDictionary(languagePair.pairId)
            .map { words -> wordsUiMapper.map(words) }
            .onEach { uiModels -> viewState.showWords(uiModels) }
            .launchIn(presenterScope)
    }
}