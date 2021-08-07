package com.app.wordsphrases.stories_impl.di

import com.app.wordsphrases.stories_api.GetWordsFromDatabase
import com.app.wordsphrases.stories_api.StoriesStarter
import com.app.wordsphrases.stories_impl.domain.use_case.GetWordsFromDatabaseImpl
import com.app.wordsphrases.stories_impl.navigation.StoriesStarterImpl
import dagger.Binds
import dagger.Module

@Module
interface StoriesApiModule {

    @Binds
    fun provideStoriesStarter(impl: StoriesStarterImpl): StoriesStarter

    @Binds
    fun provideGetWordsFromDatabase(impl: GetWordsFromDatabaseImpl): GetWordsFromDatabase
}