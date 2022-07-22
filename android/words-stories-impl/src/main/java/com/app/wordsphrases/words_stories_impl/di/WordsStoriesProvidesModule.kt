package com.app.wordsphrases.words_stories_impl.di

import com.wordphrases.domain.usecase.GetAllWordsForDictionary
import com.wordphrases.domain.usecase.language_pair.RequireSelectedLanguagePair
import dagger.*

@Module
class WordsStoriesProvidesModule {

    @Provides
    fun getWordsForStories(): GetAllWordsForDictionary {
        return GetAllWordsForDictionary()
    }

    @Provides
    fun requireSelectedLanguagePair(): RequireSelectedLanguagePair {
        return RequireSelectedLanguagePair()
    }
}