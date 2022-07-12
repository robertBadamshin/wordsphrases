package com.app.wordsphrases.edit_word_impl.di

import com.wordphrases.domain.usecase.*
import com.wordphrases.domain.usecase.word.GetWordById
import dagger.*

@Module
class EditWordProvidesModule {

    @Provides
    fun saveNewWord(): SaveNewWord {
        return SaveNewWord()
    }

    @Provides
    fun getWordById(): GetWordById {
        return GetWordById()
    }

    @Provides
    fun updateWord(): UpdateWord {
        return UpdateWord()
    }
}