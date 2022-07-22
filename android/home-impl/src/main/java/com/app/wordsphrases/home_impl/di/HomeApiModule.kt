package com.app.wordsphrases.home_impl.di

import com.app.wordsphrases.core.di.AppScope
import com.app.wordsphrases.home_api.*
import com.app.wordsphrases.home_impl.navigation.HomeStarterImpl
import com.app.wordsphrases.navigation.WordsPhrasesRouter
import dagger.*
import ru.terrakok.cicerone.*

@Module
class HomeApiModule {

    @Provides
    fun homeStarter(): HomeStarter {
        return HomeStarterImpl()
    }

    @Provides
    @AppScope
    @HomeNavigationQualifier
    fun cicerone(): Cicerone<WordsPhrasesRouter> {
        return Cicerone.create(WordsPhrasesRouter())
    }

    @Provides
    @HomeNavigationQualifier
    fun homeRouter(
        @HomeNavigationQualifier cicerone: Cicerone<WordsPhrasesRouter>
    ): WordsPhrasesRouter {
        return cicerone.router
    }

    @Provides
    @HomeNavigationQualifier
    fun navigationHolder(
        @HomeNavigationQualifier cicerone: Cicerone<WordsPhrasesRouter>
    ): NavigatorHolder {
        return cicerone.navigatorHolder
    }
}