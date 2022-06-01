package com.app.wordsphrases.stories_impl.di

import com.app.wordsphrases.core.di.AppScope
import com.app.wordsphrases.stories_api.StoriesNavigationQualifier
import dagger.*
import ru.terrakok.cicerone.*

@Module
class StoriesApiProvidesModule {

    @Provides
    @AppScope
    @StoriesNavigationQualifier
    fun cicerone(): Cicerone<Router> {
        return Cicerone.create(Router())
    }

    @Provides
    @StoriesNavigationQualifier
    fun router(@StoriesNavigationQualifier cicerone: Cicerone<Router>): Router {
        return cicerone.router
    }

    @Provides
    @StoriesNavigationQualifier
    fun navigationHolder(@StoriesNavigationQualifier cicerone: Cicerone<Router>): NavigatorHolder {
        return cicerone.navigatorHolder
    }
}