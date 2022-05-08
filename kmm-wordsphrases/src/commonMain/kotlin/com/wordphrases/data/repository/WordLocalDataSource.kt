package com.wordphrases.data.repository

import com.wordphrases.db.*
import com.wordphrases.di.QueriesProvider

class WordLocalDataSource(
    private val queries: WordTableQueries = QueriesProvider.wordTableQueries,
) {

    fun insert(entity: WordDbEntity) {
        queries.insertItem(
            wordId = entity.wordId,
            createdAt = entity.createdAt,
            wordText = entity.wordText,
            sortOrder = entity.sortOrder,
            maxRepeatCount = entity.maxRepeatCount,
            repeatCount = entity.maxRepeatCount,
        )
    }

    fun getEntities(): List<WordDbEntity> {
        return queries.selectAll().executeAsList()
    }
}