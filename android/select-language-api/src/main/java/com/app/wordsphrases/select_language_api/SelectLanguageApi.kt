package com.app.wordsphrases.select_language_api

import ru.terrakok.cicerone.*

interface SelectLanguageApi {

    val selectLanguageStarter: SelectLanguageStarter

    @get:SelectLanguageQualifier
    val selectLanguageRouter: Router

    @get:SelectLanguageQualifier
    val selectLanguageNavigatorHolder: NavigatorHolder
}