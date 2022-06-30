package com.app.wordsphrases.add_word_impl.di

import com.app.wordsphrases.add_word_api.*
import com.app.wordsphrases.add_word_impl.navigation.*
import dagger.*

@Module
interface AddWordApiModule {

    @Binds
    fun enterWordStarter(impl: AddWordStarterImpl): AddWordStarter
}