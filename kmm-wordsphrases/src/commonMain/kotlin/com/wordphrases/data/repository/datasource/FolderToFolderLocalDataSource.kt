package com.wordphrases.data.repository.datasource

import com.wordphrases.db.*
import com.wordphrases.di.QueriesProvider

class FolderToFolderLocalDataSource(
    private val queries: FolderToFolderTableQueries = QueriesProvider.folderToFolderTableQueries,
) {

    fun insert(entity: FolderToFolderDbEntity) {
        queries.insertItem(
            folderId = entity.folderId,
            parentFolderId = entity.parentFolderId,
        )
    }

    fun getEntities(): List<FolderToFolderDbEntity> {
        return queries.selectAll().executeAsList()
    }
}