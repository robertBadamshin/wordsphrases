package com.app.wordsphrases.popup_translator_impl.di

import com.wordphrases.domain.usecase.GetWords
import dagger.*

@Module
class StoriesProvidesModule {

    @Provides
    fun getWords(): GetWords {
        return GetWords()
    }
}