package com.app.wordsphrases.add_word_impl.di

import com.app.wordsphrases.add_word_api.EnterWordRouter
import com.app.wordsphrases.add_word_api.SaveWord
import com.app.wordsphrases.add_word_impl.domain.SaveWordImpl
import com.app.wordsphrases.add_word_impl.navigation.EnterWordRouterImpl
import dagger.Binds
import dagger.Module

@Module
interface AddWordApiModule {

    @Binds
    fun enterWordRouter(impl: EnterWordRouterImpl): EnterWordRouter

    @Binds
    fun saveWord(impl: SaveWordImpl): SaveWord
}