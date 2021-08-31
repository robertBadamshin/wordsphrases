package com.app.wordsphrases.add_word_impl.presentation.enter_word_screen

import androidx.annotation.StringRes
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleTagStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.OneExecution

private const val translationButtonEnabledTag = "translationButtonEnabledTag"
private const val translationButtonTag = "translationButtonTag"

@AddToEndSingle
interface EnterWordView : MvpView {

    @OneExecution
    fun showMessage(@StringRes messageRes: Int)

    fun showTranslationProgress()

    fun hideTranslationProgress()

    @StateStrategyType(AddToEndSingleTagStrategy::class, tag = translationButtonEnabledTag)
    fun setTranslateButtonEnabled()

    @StateStrategyType(AddToEndSingleTagStrategy::class, tag = translationButtonTag)
    fun setTranslateButtonDisabled()

    @StateStrategyType(AddToEndSingleTagStrategy::class, tag = translationButtonEnabledTag)
    fun showTranslateButton()

    @StateStrategyType(AddToEndSingleTagStrategy::class, tag = translationButtonEnabledTag)
    fun hideTranslateButton()

    @OneExecution
    fun showKeyboard()
}