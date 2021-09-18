package com.app.wordsphrases.popup_translator_impl.presentation

import android.os.Bundle
import android.os.PersistableBundle
import com.app.wordsphrases.popup_translator_impl.R
import com.app.wordsphrases.popup_translator_impl.di.PopupTranslatorComponent
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class PopupTranslatorActivity : MvpAppCompatActivity(), PopupTranslatorView {

    private val popupTranslatorPresenter by moxyPresenter { PopupTranslatorComponent.get().popupTranslatorPresenter }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_popup_translator)
    }
}