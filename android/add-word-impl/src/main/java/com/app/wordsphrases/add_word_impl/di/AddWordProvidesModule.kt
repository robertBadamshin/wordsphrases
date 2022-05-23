package com.app.wordsphrases.add_word_impl.di

import com.wordphrases.domain.usecase.SaveNewWord
import com.wordphrases.domain.usecase.language_pair.RequireSelectedLanguagePair
import dagger.*

@Module
class AddWordProvidesModule {

    @Provides
    fun saveNewWord(): SaveNewWord {
        return SaveNewWord()
    }

    @Provides
    fun requireSelectedLanguagePair(): RequireSelectedLanguagePair {
        return RequireSelectedLanguagePair()
    }
}