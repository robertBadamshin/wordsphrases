package com.app.wordsphrases.add_word_impl.di

import com.wordphrases.domain.usecase.SaveNewWord
import dagger.*

@Module
class AddWordProvidesModule {

    @Provides
    fun saveNewWord(): SaveNewWord {
        return SaveNewWord()
    }
}