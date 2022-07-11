package com.app.wordsphrases.word_detail_impl.di

import com.app.wordsphrases.word_detail_api.WordDetailStarter
import com.app.wordsphrases.word_detail_impl.navigation.WordDetailsStarterImpl
import dagger.*

@Module
interface WordDetailApiModule {

    @Binds
    fun wordDetailStarter(impl: WordDetailsStarterImpl): WordDetailStarter
}