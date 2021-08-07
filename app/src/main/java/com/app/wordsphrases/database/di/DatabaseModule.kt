package com.app.wordsphrases.database.di

import android.content.Context
import androidx.room.Room
import com.app.wordsphrases.add_word_impl.data.datasource.InsertWordDao
import com.app.wordsphrases.core.di.AppScope
import com.app.wordsphrases.database.AppDatabase
import com.app.wordsphrases.stories_impl.data.datasource.GetWordsDao
import dagger.Module
import dagger.Provides

private const val databaseName = "app_database"

@Module
class DatabaseModule {

    @Provides
    @AppScope
    fun provideDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, databaseName)
            .build()
    }

    @Provides
    @AppScope
    fun provideWordDao(appDatabase: AppDatabase): InsertWordDao {
        return appDatabase.wordDao()
    }

    @Provides
    @AppScope
    fun provideGetWordsDao(appDatabase: AppDatabase): GetWordsDao {
        return appDatabase.getWordsDao()
    }
}