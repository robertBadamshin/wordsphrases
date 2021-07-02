package com.app.wordsphrases.home_impl.presentation

import com.app.wordsphrases.navigation.NavigationScreen
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.OneExecution

@AddToEndSingle
interface HomeView: MvpView {

    @OneExecution
    fun openScreen(screen: NavigationScreen)
}