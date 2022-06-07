package com.app.wordsphrases.login_impl.di

import com.app.wordsphrases.login_api.EnterEmailStarter
import com.app.wordsphrases.login_impl.routing.EnterEmailStarterImpl
import dagger.*

@Module
interface LoginApiModule {

    @Binds
    fun selectLanguageStarter(impl: EnterEmailStarterImpl): EnterEmailStarter
}
