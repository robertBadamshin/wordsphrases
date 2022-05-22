package com.app.wordsphrases.popup_translator_impl.di

import com.app.wordsphrases.stories_api.StoriesStarter
import com.app.wordsphrases.stories_impl.navigation.StoriesStarterImpl
import dagger.*

@Module
interface StoriesApiModule {

    @Binds
    fun provideStoriesStarter(impl: StoriesStarterImpl): StoriesStarter
}