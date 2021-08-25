package com.app.wordsphrases.add_word_impl.presentation.add_word_screen

import com.app.wordsphrases.add_word_impl.presentation.ui.model.TranslationUiModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface AddWordView : MvpView {

    fun showTranslations(uiModels: List<TranslationUiModel>)

    fun showMessage(message: String)

    fun setWordText(word: String)
}