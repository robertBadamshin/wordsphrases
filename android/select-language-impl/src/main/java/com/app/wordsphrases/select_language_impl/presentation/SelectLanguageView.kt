package com.app.wordsphrases.select_language_impl.presentation

import androidx.annotation.AttrRes
import com.app.wordsphrases.select_language_impl.presentation.ui.model.LanguageUiModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface SelectLanguageView : MvpView {

    fun showLanguages(languages: List<LanguageUiModel>)

    fun startHeaderBackgroundAnimation(@AttrRes targetColorAttr: Int)
}