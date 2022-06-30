package com.app.wordsphrases.di

import com.app.wordsphrases.core.di.*
import com.wordphrases.domain.usecase.auth.SubscribeForAuthState
import com.wordphrases.domain.usecase.language_pair.GetCurrentSelectedLanguagePair
import dagger.*
import ru.terrakok.cicerone.*

@Module
class MainModule {

    @Provides
    fun subscribeForAuthState(): SubscribeForAuthState {
        return SubscribeForAuthState()
    }

    @Provides
    fun getCurrentSelectedLanguagePair(): GetCurrentSelectedLanguagePair {
        return GetCurrentSelectedLanguagePair()
    }

    @Provides
    @MainNavigationQualifier
    @AppScope
    fun cicerone(): Cicerone<Router> {
        return Cicerone.create(Router())
    }

    @Provides
    @MainNavigationQualifier
    fun mainRouter(
        @MainNavigationQualifier cicerone: Cicerone<Router>,
    ): Router {
        return cicerone.router
    }

    @Provides
    @MainNavigationQualifier
    fun navigationHolder(
        @MainNavigationQualifier cicerone: Cicerone<Router>
    ): NavigatorHolder {
        return cicerone.navigatorHolder
    }
}