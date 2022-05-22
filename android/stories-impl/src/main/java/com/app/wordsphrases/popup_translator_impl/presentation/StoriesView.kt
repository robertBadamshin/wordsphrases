package com.app.wordsphrases.popup_translator_impl.presentation

import android.content.Intent
import com.app.wordsphrases.popup_translator_impl.ui.model.WordUiModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.*

@AddToEndSingle
interface StoriesView : MvpView {

    fun showWord(uiModel: WordUiModel)

    fun updateBackPressedNestedNavigationEnabled(enabled: Boolean)

    fun updateAddWordButtonVisible(visible: Boolean)

    @OneExecution
    fun startEmailActivity(intent: Intent)
}