package com.app.wordsphrases.dictionary_impl.di

import com.wordphrases.domain.usecase.GetAllWordsForDictionary
import com.wordphrases.domain.usecase.language_pair.GetSelectedLanguagePair
import dagger.*

@Module
class DictionaryModule {

    @Provides
    fun provideGetAllWordsForDictionary(): GetAllWordsForDictionary {
        return GetAllWordsForDictionary()
    }

    @Provides
    fun provideGetSelectedLanguagePair(): GetSelectedLanguagePair {
        return GetSelectedLanguagePair()
    }
}