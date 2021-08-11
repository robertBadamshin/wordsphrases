package com.app.wordsphrases.add_word_impl.presentation.enter_word_screen

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleTagStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.AddToEndSingle

private const val translationButtonTag = "translationButtonTag"

@AddToEndSingle
interface EnterWordView : MvpView {

    fun showMessage(message: String)

    fun closeScreen()

    fun showTranslationProgress()

    fun hideTranslationProgress()

    @StateStrategyType(AddToEndSingleTagStrategy::class, tag = translationButtonTag)
    fun setTranslateButtonEnabled()

    @StateStrategyType(AddToEndSingleTagStrategy::class, tag = translationButtonTag)
    fun setTranslateButtonDisabled()
}