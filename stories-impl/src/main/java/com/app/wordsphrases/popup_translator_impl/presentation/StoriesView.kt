package com.app.wordsphrases.popup_translator_impl.presentation

import com.app.wordsphrases.popup_translator_impl.ui.model.WordUiModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface StoriesView : MvpView {

    fun showWord(uiModel: WordUiModel)

    fun updateBackPressedNestedNavigationEnabled(enabled: Boolean)

    fun updateAddWordButtonVisible(visible: Boolean)
}