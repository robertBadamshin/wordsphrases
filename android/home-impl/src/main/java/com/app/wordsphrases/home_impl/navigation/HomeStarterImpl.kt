package com.app.wordsphrases.home_impl.navigation

import com.app.wordsphrases.home_api.HomeStarter
import com.app.wordsphrases.home_impl.presentation.HomeFragment
import com.app.wordsphrases.navigation.NavigationScreen
import javax.inject.Inject

class HomeStarterImpl @Inject constructor() : HomeStarter {

    override fun getScreen(): NavigationScreen {
        val fragment = HomeFragment()

        return NavigationScreen(
            fragment = fragment,
        )
    }
}