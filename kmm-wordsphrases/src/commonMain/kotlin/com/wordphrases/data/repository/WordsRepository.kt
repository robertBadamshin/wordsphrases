package com.wordphrases.data.repository

import com.wordphrases.DatabaseProvider
import com.wordphrases.data.model.FirebaseUserRemote
import com.wordphrases.db.Word
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.firestore

class WordsRepository {

    private val database by lazy { DatabaseProvider().getDatabase() }

    fun putWords() {
        database.wordTableQueries.insertItem(
            12L,
            123L,
            2L,
            5L,
            2L,
        )
    }

    fun getWords(): List<Word> {
        return database.wordTableQueries.selectAll().executeAsList()
    }
}