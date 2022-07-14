package com.app.wordsphrases.edit_word_impl.presentation.add_word_screen

import androidx.annotation.StringRes
import com.app.wordsphrases.edit_word_impl.presentation.ui.model.TranslationUiModel
import moxy.MvpView
import moxy.viewstate.strategy.*
import moxy.viewstate.strategy.alias.*

private const val addWordButtonEnabledTag = "addWordButtonEnabledTag"

@AddToEndSingle
interface EditWordView : MvpView {

    @StateStrategyType(AddToEndSingleTagStrategy::class, tag = addWordButtonEnabledTag)
    fun setAddWordButtonEnabled()

    @StateStrategyType(AddToEndSingleTagStrategy::class, tag = addWordButtonEnabledTag)
    fun setAddWordButtonDisabled()

    @OneExecution
    fun showKeyboard()

    @OneExecution
    fun setInitialText(text: String)

    fun showTranslations(uiModels: List<TranslationUiModel>)

    fun showToastMessage(@StringRes messageRes: Int)

    @OneExecution
    fun setCommentText(text: String?)
}