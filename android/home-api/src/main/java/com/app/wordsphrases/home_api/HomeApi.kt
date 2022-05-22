package com.app.wordsphrases.home_api

import ru.terrakok.cicerone.*

interface HomeApi {

    @HomeNavigationQualifier
    val homeRouter: HomeRouter

    @get:HomeNavigationQualifier
    val router: Router

    @get:HomeNavigationQualifier
    val navigatorHolder: NavigatorHolder
}