package com.wordphrases.database

import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import com.wordphrases.db.WordsphrasesDatabase

fun createDatabase(): WordsphrasesDatabase {
    val driver = NativeSqliteDriver(WordsphrasesDatabase.Schema, "WordsphrasesDatabase.db")
    return WordsphrasesDatabase(driver)
}