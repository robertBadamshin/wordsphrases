package com.app.wordsphrases.stories_impl.presentation

import moxy.MvpView
import moxy.viewstate.strategy.alias.*

@AddToEndSingle
interface PopupTranslatorView : MvpView {

    @OneExecution
    fun closeScreen()
}