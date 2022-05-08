package com.wordphrases.di

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.wordphrases.db.WordsphrasesDatabase

lateinit var appContext: Context

actual fun createDatabase(): WordsphrasesDatabase {
    val driver = AndroidSqliteDriver(
        WordsphrasesDatabase.Schema,
        appContext,
        "WordsphrasesDatabase.db"
    )
    return WordsphrasesDatabase(driver)
}