package com.app.wordsphrases.add_word_impl.di

import com.app.wordsphrases.add_word_api.AddWordRouter
import com.app.wordsphrases.add_word_api.SaveWord
import com.app.wordsphrases.add_word_impl.domain.SaveWordImpl
import com.app.wordsphrases.add_word_impl.navigation.AddWordRouterImpl
import dagger.Binds
import dagger.Module

@Module
interface AddWordApiModule {

    @Binds
    fun bindAddWordRouter(impl: AddWordRouterImpl): AddWordRouter

    @Binds
    fun bindSaveWord(impl: SaveWordImpl): SaveWord
}