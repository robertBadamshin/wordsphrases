package com.app.wordsphrases.presentation

import androidx.annotation.StringRes
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface MainView : MvpView {

    fun showToast(@StringRes stringRes: Int)
}