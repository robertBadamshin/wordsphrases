package com.wordphrases.di

import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import com.wordphrases.db.WordsphrasesDatabase

actual fun createDatabase(): WordsphrasesDatabase {
    val driver = NativeSqliteDriver(
        schema = WordsphrasesDatabase.Schema,
        name = "WordsphrasesDatabase.db",
        // TODO check how to work with https://github.com/cashapp/sqldelight/issues/1356
    )
    return WordsphrasesDatabase(driver)
}