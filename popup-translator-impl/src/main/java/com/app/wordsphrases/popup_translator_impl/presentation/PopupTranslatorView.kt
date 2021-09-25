package com.app.wordsphrases.popup_translator_impl.presentation

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleTagStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.OneExecution

private const val translationButtonEnabledTag = "translationButtonEnabledTag"
private const val translationButtonTagVisibility = "translationButtonTag"

@AddToEndSingle
interface PopupTranslatorView : MvpView {

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
    fun showMessage(messageRes: Int)
}