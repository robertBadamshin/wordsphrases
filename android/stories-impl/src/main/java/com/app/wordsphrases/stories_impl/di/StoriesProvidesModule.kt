package com.app.wordsphrases.stories_impl.di

import com.wordphrases.domain.usecase.GetWordsForStories
import dagger.*

@Module
class StoriesProvidesModule {

    @Provides
    fun getWordsForStories(): GetWordsForStories {
        return GetWordsForStories()
    }
}