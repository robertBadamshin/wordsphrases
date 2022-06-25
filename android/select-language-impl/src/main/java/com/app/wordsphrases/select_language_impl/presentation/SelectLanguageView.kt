package com.app.wordsphrases.select_language_impl.presentation

import android.content.Intent
import androidx.annotation.StringRes
import com.app.wordsphrases.select_language_impl.presentation.ui.model.LanguageUiModel
import com.wordphrases.domain.entity.language.Language
import moxy.MvpView
import moxy.viewstate.strategy.alias.*

@AddToEndSingle
interface SelectLanguageView : MvpView {

    fun showLanguages(languages: List<LanguageUiModel>)

    fun setTitle(@StringRes titleRes: Int)

    fun setScreenResult(key: String, language: Language)

    @OneExecution
    fun startIntent(intent: Intent)
}