package com.app.wordsphrases.words_stories_impl.presentation

import com.app.wordsphrases.words_stories_impl.presentation.ui.model.WordUiModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface WordStoriesView : MvpView {

    fun showWords(words: List<WordUiModel>)
}