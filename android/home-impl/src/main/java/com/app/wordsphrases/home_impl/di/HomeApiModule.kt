package com.app.wordsphrases.home_impl.di

import com.app.wordsphrases.core.di.AppScope
import com.app.wordsphrases.home_api.HomeNavigationQualifier
import com.app.wordsphrases.home_api.HomeRouter
import com.app.wordsphrases.home_impl.navigation.HomeRouterImpl
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

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