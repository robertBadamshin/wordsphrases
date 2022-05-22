package com.app.wordsphrases.home_impl.navigation

import com.app.wordsphrases.home_api.HomeRouter
import com.app.wordsphrases.home_impl.presentation.HomeFragment
import com.app.wordsphrases.navigation.NavigationScreen
import javax.inject.Inject

class HomeRouterImpl @Inject constructor() : HomeRouter {

    override fun getScreen(): NavigationScreen {
        val fragment = HomeFragment()

        return NavigationScreen(
            fragment = fragment,
        )
    }
}