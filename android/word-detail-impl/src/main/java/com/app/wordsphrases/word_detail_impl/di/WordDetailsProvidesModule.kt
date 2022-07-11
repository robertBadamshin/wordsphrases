package com.app.wordsphrases.word_detail_impl.di

import com.wordphrases.domain.usecase.word.GetWordById
import dagger.*

@Module
class WordDetailsProvidesModule {

    @Provides
    fun provideGetWordById(): GetWordById {
        return GetWordById()
    }
}