package com.app.wordsphrases.home_api

import ru.terrakok.cicerone.*

interface HomeApi {

    @HomeNavigationQualifier
    val homeStarter: HomeStarter

    @get:HomeNavigationQualifier
    val homeRouter: Router

    @get:HomeNavigationQualifier
    val navigatorHolder: NavigatorHolder
}