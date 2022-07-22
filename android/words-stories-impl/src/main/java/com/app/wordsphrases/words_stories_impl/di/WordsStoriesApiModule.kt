package com.app.wordsphrases.words_stories_impl.di

import com.app.wordsphrases.words_stories_api.WordsStoriesRouter
import com.app.wordsphrases.words_stories_impl.di.navigation.WordsStoriesRouterImpl
import dagger.*

@Module
interface WordsStoriesApiModule {

    @Binds
    fun wordsStoriesStarter(impl: WordsStoriesRouterImpl): WordsStoriesRouter
}