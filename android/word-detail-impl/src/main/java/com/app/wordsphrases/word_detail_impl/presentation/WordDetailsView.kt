package com.app.wordsphrases.word_detail_impl.presentation

import com.app.wordsphrases.word_detail_impl.presentation.ui.model.WordUiModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface WordDetailsView : MvpView {

    fun showWord(uiModel: WordUiModel)
}