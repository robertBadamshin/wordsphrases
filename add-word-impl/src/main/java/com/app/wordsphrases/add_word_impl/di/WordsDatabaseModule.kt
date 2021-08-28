package com.app.wordsphrases.add_word_impl.di

import android.content.Context
import androidx.room.Room
import com.app.wordsphrases.add_word_impl.data.database.WordsDatabase
import com.app.wordsphrases.add_word_impl.data.datasource.GetWordsDao
import com.app.wordsphrases.add_word_impl.data.datasource.InsertWordDao
import com.app.wordsphrases.core.di.AppScope
import com.app.wordsphrases.core.di.FeatureScope
import dagger.Module
import dagger.Provides

private const val databaseName = "words_database"

@Module
class WordsDatabaseModule {

    @Provides
    fun provideDatabase(context: Context): WordsDatabase {
        return Room.databaseBuilder(context.applicationContext, WordsDatabase::class.java, databaseName)
            .build()
    }

    @Provides
    fun provideWordDao(appDatabase: WordsDatabase): InsertWordDao {
        return appDatabase.wordDao()
    }


    @Provides
    fun provideGetWordsDao(appDatabase: WordsDatabase): GetWordsDao {
        return appDatabase.getWordsDao()
    }
}