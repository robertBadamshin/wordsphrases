package com.app.wordsphrases.home_api

import com.app.wordsphrases.navigation.WordsPhrasesRouter
import ru.terrakok.cicerone.NavigatorHolder

interface HomeApi {

    @HomeNavigationQualifier
    val homeStarter: HomeStarter

    @get:HomeNavigationQualifier
    val homeRouter: WordsPhrasesRouter

    @get:HomeNavigationQualifier
    val navigatorHolder: NavigatorHolder
}