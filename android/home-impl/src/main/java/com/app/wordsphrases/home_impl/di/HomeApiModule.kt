package com.app.wordsphrases.home_impl.di

import com.app.wordsphrases.core.di.AppScope
import com.app.wordsphrases.home_api.*
import com.app.wordsphrases.home_impl.navigation.HomeRouterImpl
import dagger.*
import ru.terrakok.cicerone.*

@Module
class HomeApiModule {

    @Provides
    fun homeRouter(): HomeRouter {
        return HomeRouterImpl()
    }

    @Provides
    @AppScope
    @HomeNavigationQualifier
    fun cicerone(): Cicerone<Router> {
        return Cicerone.create(Router())
    }

    @Provides
    @HomeNavigationQualifier
    fun router(@HomeNavigationQualifier cicerone: Cicerone<Router>): Router {
        return cicerone.router
    }

    @Provides
    @HomeNavigationQualifier
    fun navigationHolder(@HomeNavigationQualifier cicerone: Cicerone<Router>): NavigatorHolder {
        return cicerone.navigatorHolder
    }
}