package com.app.wordsphrases.stories_impl.di

import com.wordphrases.domain.usecase.GetWordsForStories
import com.wordphrases.domain.usecase.language_pair.GetSelectedLanguagePair
import dagger.*

@Module
class StoriesProvidesModule {

    @Provides
    fun getWordsForStories(): GetWordsForStories {
        return GetWordsForStories()
    }

    @Provides
    fun getSelectedLanguagePair(): GetSelectedLanguagePair {
        return GetSelectedLanguagePair()
    }
}