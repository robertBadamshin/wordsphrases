package com.app.wordsphrases.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.app.wordsphrases.add_word_impl.data.datasource.WordDao
import com.app.wordsphrases.add_word_impl.data.entity.WordDbEntity


@Database(entities = [WordDbEntity::class], exportSchema = false, version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun wordDao(): WordDao
}