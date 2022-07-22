package com.app.wordsphrases.core.di

import com.app.wordsphrases.navigation.WordsPhrasesRouter

interface MainApi {

    @get:MainNavigationQualifier
    val mainRouter: WordsPhrasesRouter
}