package com.app.wordsphrases.add_word_impl.presentation.select_translation_fragment

import androidx.annotation.StringRes
import com.app.wordsphrases.add_word_impl.presentation.ui.model.MarginUiModel
import moxy.MvpView
import moxy.viewstate.strategy.*
import moxy.viewstate.strategy.alias.AddToEndSingle

private const val doneButtonEnabledTag = "doneButtonEnabledTag"

@AddToEndSingle
interface SelectTranslationView : MvpView {

    fun showMessage(message: String)

    fun setWordText(word: String)

    @StateStrategyType(AddToEndSingleTagStrategy::class, tag = doneButtonEnabledTag)
    fun setDoneButtonEnabled()

    @StateStrategyType(AddToEndSingleTagStrategy::class, tag = doneButtonEnabledTag)
    fun setDoneButtonDisabled()

    fun setWordToMargin(uiModel: MarginUiModel)

    fun showToastMessage(@StringRes messageRes: Int)
}