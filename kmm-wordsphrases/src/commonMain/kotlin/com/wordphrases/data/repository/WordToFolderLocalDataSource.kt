package com.wordphrases.data.repository

import com.wordphrases.db.*
import com.wordphrases.di.QueriesProvider

class WordToFolderLocalDataSource(
    private val queries: WordToFolderTableQueries = QueriesProvider.wordToFolderTableQueries,
) {

    fun insert(entity: WordToFolderDbEntity) {
        queries.insertItem(
            wordId = entity.wordId,
            folderId = entity.folderId,
        )
    }

    fun getEntities(): List<WordToFolderDbEntity> {
        return queries.selectAll().executeAsList()
    }
}