package com.app.wordsphrases.stories_impl.di

import com.app.wordsphrases.core.di.AppScope
import com.app.wordsphrases.stories_api.StoriesNavigationQualifier
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

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