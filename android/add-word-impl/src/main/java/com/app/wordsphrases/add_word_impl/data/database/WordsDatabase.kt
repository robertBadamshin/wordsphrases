package com.app.wordsphrases.add_word_impl.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.wordsphrases.add_word_impl.data.datasource.GetWordsDao
import com.app.wordsphrases.add_word_impl.data.datasource.InsertWordDao
import com.app.wordsphrases.entity.word.WordDbEntity

@Database(entities = [WordDbEntity::class], exportSchema = false, version = 1)
abstract class WordsDatabase : RoomDatabase() {

    abstract fun wordDao(): InsertWordDao

    abstract fun getWordsDao(): GetWordsDao
}