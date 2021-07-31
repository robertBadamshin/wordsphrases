package com.app.wordsphrases.add_word_impl.presentation

import com.app.wordsphrases.add_word_impl.domain.entity.WordImage
import com.app.wordsphrases.add_word_impl.presentation.ui.model.TranslationsViewState
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface AddWordView : MvpView {

    fun showTranslations(viewState: TranslationsViewState)

    fun setImage(image: WordImage)

    fun showMessage(message: String)
}