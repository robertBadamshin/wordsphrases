package com.app.wordsphrases.add_word_impl.presentation.enter_word_screen

import androidx.annotation.StringRes
import moxy.MvpView
import moxy.viewstate.strategy.*
import moxy.viewstate.strategy.alias.*

private const val translationButtonEnabledTag = "translationButtonEnabledTag"
private const val translationButtonTagVisibility = "translationButtonTag"

@AddToEndSingle
interface EnterWordView : MvpView {

    @OneExecution
    fun showMessage(@StringRes messageRes: Int)

    fun showTranslationProgress()

    fun hideTranslationProgress()

    @StateStrategyType(AddToEndSingleTagStrategy::class, tag = translationButtonEnabledTag)
    fun setTranslateButtonEnabled()

    @StateStrategyType(AddToEndSingleTagStrategy::class, tag = translationButtonEnabledTag)
    fun setTranslateButtonDisabled()

    @StateStrategyType(AddToEndSingleTagStrategy::class, tag = translationButtonTagVisibility)
    fun showTranslateButton()

    @StateStrategyType(AddToEndSingleTagStrategy::class, tag = translationButtonTagVisibility)
    fun hideTranslateButton()

    @OneExecution
    fun showKeyboard()

    @OneExecution
    fun setInitialText(text: String)
}