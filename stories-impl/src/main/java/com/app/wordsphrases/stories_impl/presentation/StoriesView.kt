package com.app.wordsphrases.stories_impl.presentation

import com.app.wordsphrases.navigation.NavigationScreen
import com.app.wordsphrases.stories_impl.ui.model.WordUiModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.OneExecution

@AddToEndSingle
interface StoriesView : MvpView {

    @OneExecution
    fun openScreen(screen: NavigationScreen)

    fun showWord(uiModel: WordUiModel)

    fun updateBackPressedNestedNavigationEnabled(enabled: Boolean)

    fun updateAddWordButtonVisible(enabled: Boolean)
}