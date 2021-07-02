package com.app.wordsphrases.presentation

import com.app.wordsphrases.navigation.NavigationScreen
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface MainView : MvpView {

    fun start(screen: NavigationScreen)
}