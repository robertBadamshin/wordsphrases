package com.wordphrases.di

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.wordphrases.db.WordsphrasesDatabase

lateinit var appContextForDatabase: Context

actual fun createDatabase(): WordsphrasesDatabase {
    val driver = AndroidSqliteDriver(
        WordsphrasesDatabase.Schema,
        appContextForDatabase,
        "WordsphrasesDatabase.db"
    )
    return WordsphrasesDatabase(driver)
}