package com.wordphrases.di

object QueriesProvider {

    private val database by lazy { createDatabase() }

    val wordTableQueries by lazy { database.wordTableQueries }

    val folderTableQueries by lazy { database.folderTableQueries }

    val folderToFolderTableQueries by lazy { database.folderToFolderTableQueries }

    val translationTableQueries by lazy { database.translationTableQueries }

    val wordToFolderTableQueries by lazy { database.wordToFolderTableQueries }
}