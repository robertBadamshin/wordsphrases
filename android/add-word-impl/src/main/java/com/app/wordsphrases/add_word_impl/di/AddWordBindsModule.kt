package com.app.wordsphrases.add_word_impl.di

import com.app.wordsphrases.add_word_impl.data.database.WordsDatabase
import com.app.wordsphrases.add_word_impl.data.datasource.InsertWordDao
import com.app.wordsphrases.core.di.FeatureScope
import dagger.Module
import dagger.Provides

@Module
class AddWordBindsModule  {

    @Provides
    @FeatureScope
    fun provideWordDao(appDatabase: WordsDatabase): InsertWordDao {
        return appDatabase.wordDao()
    }
}