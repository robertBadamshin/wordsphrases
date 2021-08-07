package com.app.wordsphrases.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.wordsphrases.add_word_impl.data.datasource.InsertWordDao
import com.app.wordsphrases.entity.word.WordDbEntity
import com.app.wordsphrases.stories_impl.data.datasource.GetWordsDao


@Database(entities = [WordDbEntity::class], exportSchema = false, version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun wordDao(): InsertWordDao

    abstract fun getWordsDao(): GetWordsDao
}