package com.app.wordsphrases.popup_translator_impl.presentation

import moxy.MvpView
import moxy.viewstate.strategy.alias.*

@AddToEndSingle
interface PopupTranslatorView : MvpView {

    @OneExecution
    fun closeScreen()
}