package com.app.wordsphrases.popup_translator_impl.presentation

import moxy.MvpPresenter
import javax.inject.Inject

class PopupTranslatorPresenter @Inject constructor() : MvpPresenter<PopupTranslatorView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        val a = "dasdas"
        val b = "a" + a
    }
}