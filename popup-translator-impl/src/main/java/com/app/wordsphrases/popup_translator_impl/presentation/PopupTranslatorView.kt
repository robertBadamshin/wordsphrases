package com.app.wordsphrases.popup_translator_impl.presentation

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.OneExecution

@AddToEndSingle
interface PopupTranslatorView : MvpView {

    @OneExecution
    fun beginPopupAddWordComponentCreation()
}