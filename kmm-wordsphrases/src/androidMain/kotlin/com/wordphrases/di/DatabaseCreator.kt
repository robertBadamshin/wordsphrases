package com.wordphrases.di

import android.content.Context
import androidx.sqlite.db.SupportSQLiteDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.wordphrases.db.WordsphrasesDatabase

lateinit var appContextForDatabase: Context

actual fun createDatabase(): WordsphrasesDatabase {
    val driver = AndroidSqliteDriver(
        schema = WordsphrasesDatabase.Schema,
        context = appContextForDatabase,
        name = "WordsphrasesDatabase.db",
        callback = object : AndroidSqliteDriver.Callback(WordsphrasesDatabase.Schema) {
            override fun onConfigure(db: SupportSQLiteDatabase) {
                super.onConfigure(db)
                db.setForeignKeyConstraintsEnabled(true)
            }
        }
    )
    return WordsphrasesDatabase(driver)
}