package com.app.wordsphrases.add_word_impl.di

import com.app.wordsphrases.add_word_api.EnterWordStarter
import com.app.wordsphrases.add_word_api.SaveWord
import com.app.wordsphrases.add_word_impl.domain.SaveWordImpl
import com.app.wordsphrases.add_word_impl.navigation.EnterWordStarterImpl
import dagger.Binds
import dagger.Module

@Module
interface AddWordApiModule {

    @Binds
    fun enterWordStarter(impl: EnterWordStarterImpl): EnterWordStarter

    @Binds
    fun saveWord(impl: SaveWordImpl): SaveWord
}