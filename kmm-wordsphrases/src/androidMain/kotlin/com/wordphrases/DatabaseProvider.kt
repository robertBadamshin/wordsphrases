package com.wordphrases

import com.wordphrases.database.createDatabase
import com.wordphrases.db.WordsphrasesDatabase

actual class DatabaseProvider actual constructor() {

    actual fun getDatabase(): WordsphrasesDatabase {
        return createDatabase()
    }
}