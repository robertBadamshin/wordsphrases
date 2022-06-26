package com.app.wordsphrases.add_word_impl.presentation.add_word_screen

import com.app.wordsphrases.add_word_impl.presentation.ui.model.TranslationUiModel
import moxy.MvpView
import moxy.viewstate.strategy.*
import moxy.viewstate.strategy.alias.*

private const val addWordButtonEnabledTag = "addWordButtonEnabledTag"

@AddToEndSingle
interface AddWordView : MvpView {

    @StateStrategyType(AddToEndSingleTagStrategy::class, tag = addWordButtonEnabledTag)
    fun setAddWordButtonEnabled()

    @StateStrategyType(AddToEndSingleTagStrategy::class, tag = addWordButtonEnabledTag)
    fun setAddWordButtonDisabled()

    @OneExecution
    fun showKeyboard()

    @OneExecution
    fun setInitialText(text: String)

    fun showTranslations(uiModels: List<TranslationUiModel>)
}