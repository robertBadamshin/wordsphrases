package com.app.wordsphrases.add_word_impl.di

import android.content.Context
import androidx.room.Room
import com.app.wordsphrases.add_word_impl.data.database.WordsDatabase
import com.app.wordsphrases.add_word_impl.data.datasource.GetWordsDao
import com.app.wordsphrases.add_word_impl.data.datasource.InsertWordDao
import com.app.wordsphrases.add_word_impl.di.database.WordDatabaseScope
import dagger.Module
import dagger.Provides

private const val databaseName = "words_database"

@Module
class WordsDatabaseModule {

    @Provides
    @WordDatabaseScope
    fun provideDatabase(context: Context): WordsDatabase {
        return Room.databaseBuilder(context.applicationContext, WordsDatabase::class.java, databaseName)
            .build()
    }

    @Provides
    @WordDatabaseScope
    fun provideWordDao(appDatabase: WordsDatabase): InsertWordDao {
        return appDatabase.wordDao()
    }


    @Provides
    @WordDatabaseScope
    fun provideGetWordsDao(appDatabase: WordsDatabase): GetWordsDao {
        return appDatabase.getWordsDao()
    }
}