package com.app.wordsphrases.dictionary_impl.presentation

import com.app.wordsphrases.core.di.MainNavigationQualifier
import com.app.wordsphrases.dictionary_impl.presentation.ui.mapper.WordUiMapper
import com.app.wordsphrases.edit_word_api.*
import com.app.wordsphrases.edit_word_api.domain.entity.EditWordType
import com.app.wordsphrases.navigation.WordsPhrasesRouter
import com.app.wordsphrases.word_detail_api.WordDetailStarter
import com.app.wordsphrases.words_stories_api.WordsStoriesRouter
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
    private val wordDetailStarter: WordDetailStarter,
    @MainNavigationQualifier private val router: WordsPhrasesRouter,
    private val editWordStarter: EditWordStarter,
    private val wordsStoriesRouter: WordsStoriesRouter,
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
        val screen = wordDetailStarter.getScreen(wordId)
        router.navigateTo(screen)
    }

    fun openEnterWord() {
        val initParams = EditWordInitParams(EditWordType.AddWord)
        val screen = editWordStarter.getScreen(initParams = initParams)
        router.navigateTo(screen)
    }

    fun onShuffleClick() {
        wordsStoriesRouter.openScreen()
    }
}