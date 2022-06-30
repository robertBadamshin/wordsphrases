package com.app.wordsphrases.select_language_impl.presentation

import com.app.wordsphrases.select_language_impl.presentation.ui.model.LanguagePairUiModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface LanguagePairView : MvpView {

    fun startListenForNativeLanguageResult(key: String)

    fun startListenForLearningLanguageResult(key: String)

    fun setLanguages(uiModel: LanguagePairUiModel)
}