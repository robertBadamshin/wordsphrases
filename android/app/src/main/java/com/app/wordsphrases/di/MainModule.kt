package com.app.wordsphrases.di

import com.wordphrases.domain.usecase.auth.SubscribeForAuthState
import dagger.*

@Module
class MainModule {

    @Provides
    fun subscribeForAuthState(): SubscribeForAuthState {
        return SubscribeForAuthState()
    }
}