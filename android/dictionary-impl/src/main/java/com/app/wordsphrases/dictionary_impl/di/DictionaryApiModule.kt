package com.app.wordsphrases.dictionary_impl.di

import com.app.wordsphrases.dictionary_api.DictionaryStarter
import com.app.wordsphrases.dictionary_impl.navigation.DictionaryStarterImpl
import dagger.*

@Module
interface DictionaryApiModule {

    @Binds
    fun languagePairStarter(impl: DictionaryStarterImpl): DictionaryStarter
}