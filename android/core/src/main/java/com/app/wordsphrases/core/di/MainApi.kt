package com.app.wordsphrases.core.di

import ru.terrakok.cicerone.Router

interface MainApi {

    @get:MainNavigationQualifier
    @MainNavigationQualifier
    val router: Router
}