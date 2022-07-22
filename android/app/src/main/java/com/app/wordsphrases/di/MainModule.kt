package com.app.wordsphrases.di

import com.app.wordsphrases.core.di.*
import com.app.wordsphrases.navigation.WordsPhrasesRouter
import com.wordphrases.domain.usecase.auth.*
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
    fun authenticateUser(): AuthenticateUser {
        return AuthenticateUser()
    }

    @Provides
    @MainNavigationQualifier
    @AppScope
    fun cicerone(): Cicerone<WordsPhrasesRouter> {
        return Cicerone.create(WordsPhrasesRouter())
    }

    @Provides
    @MainNavigationQualifier
    fun mainRouter(
        @MainNavigationQualifier cicerone: Cicerone<WordsPhrasesRouter>,
    ): WordsPhrasesRouter {
        return cicerone.router
    }

    @Provides
    @MainNavigationQualifier
    fun navigationHolder(
        @MainNavigationQualifier cicerone: Cicerone<WordsPhrasesRouter>
    ): NavigatorHolder {
        return cicerone.navigatorHolder
    }
}