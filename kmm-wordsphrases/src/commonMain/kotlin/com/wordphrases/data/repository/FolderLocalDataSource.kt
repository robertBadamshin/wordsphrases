package com.wordphrases.data.repository

import com.wordphrases.db.*
import com.wordphrases.di.QueriesProvider

class FolderLocalDataSource(
    private val queries: FolderTableQueries = QueriesProvider.folderTableQueries,
) {

    fun insert(entity: FolderDbEntity) {
        queries.insertItem(
            folderId = entity.folderId,
            createdAt = entity.createdAt,
            name = entity.name,
        )
    }

    fun getEntities(): List<FolderDbEntity> {
        return queries.selectAll().executeAsList()
    }
}