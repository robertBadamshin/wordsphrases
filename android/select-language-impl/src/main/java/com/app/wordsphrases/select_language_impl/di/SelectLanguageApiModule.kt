package com.app.wordsphrases.select_language_impl.di

import com.app.wordsphrases.select_language_api.SelectLanguageStarter
import com.app.wordsphrases.select_language_impl.di.navigation.SelectLanguageStarterImpl
import dagger.*

@Module
interface SelectLanguageApiModule {

    @Binds
    fun languagePairStarter (impl: SelectLanguageStarterImpl): SelectLanguageStarter
}