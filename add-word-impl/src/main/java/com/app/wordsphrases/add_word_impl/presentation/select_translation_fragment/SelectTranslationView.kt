package com.app.wordsphrases.add_word_impl.presentation.select_translation_fragment

import com.app.wordsphrases.add_word_impl.presentation.ui.model.MarginUiModel
import com.app.wordsphrases.add_word_impl.presentation.ui.model.TranslationUiModel
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleTagStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.AddToEndSingle

private const val doneButtonEnabledTag = "doneButtonEnabledTag"

@AddToEndSingle
interface SelectTranslationView : MvpView {

    fun showTranslations(uiModels: List<TranslationUiModel>)

    fun showMessage(message: String)

    fun setWordText(word: String)

    @StateStrategyType(AddToEndSingleTagStrategy::class, tag = doneButtonEnabledTag)
    fun setDoneButtonEnabled()

    @StateStrategyType(AddToEndSingleTagStrategy::class, tag = doneButtonEnabledTag)
    fun setDoneButtonDisabled()

    fun setWordToMargin(uiModel: MarginUiModel)
}