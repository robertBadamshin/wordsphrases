package com.app.wordsphrases.add_word_impl.presentation.add_word_screen

import com.app.wordsphrases.add_word_api.WordImage
import com.app.wordsphrases.add_word_impl.presentation.ui.model.TranslationsViewState
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface AddWordView : MvpView {

    fun showTranslations(viewState: TranslationsViewState)

    fun showSelectedTranslation(translation: String)

    fun setImage(image: WordImage?)

    fun showMessage(message: String)

    fun closeScreen()
}