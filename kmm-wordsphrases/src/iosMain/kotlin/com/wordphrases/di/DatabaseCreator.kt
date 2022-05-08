package com.wordphrases.di

import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import com.wordphrases.db.WordsphrasesDatabase

actual fun createDatabase(): WordsphrasesDatabase {
    val driver = NativeSqliteDriver(WordsphrasesDatabase.Schema, "WordsphrasesDatabase.db")
    return WordsphrasesDatabase(driver)
}