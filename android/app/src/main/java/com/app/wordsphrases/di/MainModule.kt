package com.app.wordsphrases.di

import com.wordphrases.domain.usecase.auth.IsAuthorized
import dagger.*

@Module
class MainModule {

    @Provides
    fun provideIsAuthorized(): IsAuthorized {
        return IsAuthorized()
    }
}