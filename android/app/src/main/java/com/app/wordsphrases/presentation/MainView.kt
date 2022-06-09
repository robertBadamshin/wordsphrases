package com.app.wordsphrases.presentation

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import ru.terrakok.cicerone.android.support.SupportAppScreen

@AddToEndSingle
interface MainView : MvpView {

    fun start(screen: SupportAppScreen)
}