package com.app.wordsphrases.words_stories_impl.di

import com.app.wordsphrases.words_stories_api.WordsStoriesStarter
import com.app.wordsphrases.words_stories_impl.di.navigation.WordsStoriesStarterImpl
import dagger.*

@Module
interface WordsStoriesApiModule {

    @Binds
    fun wordsStoriesStarter(impl: WordsStoriesStarterImpl): WordsStoriesStarter
}