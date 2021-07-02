package com.app.wordsphrases.add_word_impl.di

import com.app.wordsphrases.translation_api.AddWordRouter
import com.app.wordsphrases.add_word_impl.navigation.AddWordRouterImpl
import dagger.Binds
import dagger.Module

@Module
interface AddWordApiModule {

    @Binds
    fun bind(impl: AddWordRouterImpl): AddWordRouter
}