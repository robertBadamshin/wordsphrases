package com.app.wordsphrases.add_word_impl.presentation.enter_word_screen

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface EnterWordView : MvpView {

    fun showMessage(message: String)

    fun closeScreen()
}