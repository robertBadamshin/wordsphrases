package com.app.wordsphrases.stories_impl.di

import com.wordphrases.domain.usecase.GetAllWordsForDictionary
import com.wordphrases.domain.usecase.language_pair.GetSelectedLanguagePair
import dagger.*

@Module
class StoriesProvidesModule {

    @Provides
    fun getWordsForStories(): GetAllWordsForDictionary {
        return GetAllWordsForDictionary()
    }

    @Provides
    fun getSelectedLanguagePair(): GetSelectedLanguagePair {
        return GetSelectedLanguagePair()
    }
}