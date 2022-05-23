package com.app.wordsphrases.di

import com.wordphrases.domain.usecase.auth.SubscribeForAuthState
import com.wordphrases.domain.usecase.language_pair.*
import dagger.*

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
    fun createDefaultLanguagePair(): CreateDefaultLanguagePair {
        return CreateDefaultLanguagePair()
    }
}