package com.app.wordsphrases.stories_impl.presentation

import com.app.wordsphrases.stories_impl.domain.use_case.GetCurrentWord
import com.app.wordsphrases.stories_impl.domain.use_case.MoveToNextWord
import com.app.wordsphrases.stories_impl.domain.use_case.SubscribeForWords
import com.app.wordsphrases.stories_impl.ui.model.mapper.WordUiMapper
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject

class StoriesPresenter @Inject constructor(
    private val getCurrentWord: GetCurrentWord,
    private val wordUiMapper: WordUiMapper,
    private val subscribeForWords: SubscribeForWords,
    private val moveToNextWord: MoveToNextWord,
) : MvpPresenter<StoriesView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        getCurrentWord()
            .map { word -> wordUiMapper.map(word) }
            .onEach { uiModel -> viewState.showWord(uiModel) }
            .launchIn(presenterScope)

        presenterScope.launch {
            subscribeForWords()
        }
    }

    fun onNextWordClick() {
        moveToNextWord()
    }
}