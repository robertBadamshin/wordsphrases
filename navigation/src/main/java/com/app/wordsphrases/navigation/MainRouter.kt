package com.app.wordsphrases.navigation

import androidx.fragment.app.Fragment

interface MainRouter {

    fun startScreen(screen: NavigationScreen)

    fun closeScreen(fragment: Fragment)
}