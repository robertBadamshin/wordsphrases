package com.app.wordsphrases.core.di

import ru.terrakok.cicerone.Router

interface MainApi {

    @get:MainNavigationQualifier
    val mainRouter: Router
}