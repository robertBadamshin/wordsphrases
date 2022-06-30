package com.app.wordsphrases.dictionary_impl.presentation

import com.app.wordsphrases.dictionary_impl.presentation.ui.WordUiModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface DictionaryView : MvpView {

    fun setWords(uiModels: List<WordUiModel>)
}