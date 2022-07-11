package com.app.wordsphrases.edit_word_impl.di

import com.wordphrases.domain.usecase.SaveNewWord
import dagger.*

@Module
class EditWordProvidesModule {

    @Provides
    fun saveNewWord(): SaveNewWord {
        return SaveNewWord()
    }
}