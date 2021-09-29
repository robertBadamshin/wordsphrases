package com.app.wordsphrases.home_api

import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

interface HomeApi {

    @HomeNavigationQualifier
    val homeRouter: HomeRouter

    @get:HomeNavigationQualifier
    val router: Router

    @get:HomeNavigationQualifier
    val navigatorHolder: NavigatorHolder
}