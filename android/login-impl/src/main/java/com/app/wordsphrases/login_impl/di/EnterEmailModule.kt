package com.app.wordsphrases.login_impl.di

import com.wordphrases.domain.usecase.auth.SendLoginLinkToEmail
import dagger.*

@Module
class EnterEmailModule {

    @Provides
    fun sendLoginLinkToEmail(): SendLoginLinkToEmail {
        return SendLoginLinkToEmail()
    }
}
