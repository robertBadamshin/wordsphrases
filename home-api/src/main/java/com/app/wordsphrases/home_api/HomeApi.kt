package com.app.wordsphrases.home_api

import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

interface HomeApi {

    val homeRouter: HomeRouter

    val router: Router

    val navigatorHolder: NavigatorHolder
}