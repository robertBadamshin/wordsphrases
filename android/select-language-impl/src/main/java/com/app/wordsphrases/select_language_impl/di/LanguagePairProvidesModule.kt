package com.app.wordsphrases.select_language_impl.di

import com.wordphrases.domain.usecase.language_pair.SaveLanguagePair
import dagger.*

@Module
class LanguagePairProvidesModule {

    @Provides
    fun saveLanguagePair(): SaveLanguagePair {
        return SaveLanguagePair()
    }
}