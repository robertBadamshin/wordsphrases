package com.wordphrases

import com.wordphrases.db.WordsphrasesDatabase

expect class DatabaseProvider() {

    fun getDatabase(): WordsphrasesDatabase
}