package com.wordphrases.data.repository

import com.squareup.sqldelight.TransactionWithoutReturn
import com.squareup.sqldelight.runtime.coroutines.*
import com.wordphrases.db.*
import com.wordphrases.di.QueriesProvider
import kotlinx.coroutines.flow.*

class WordLocalDataSource(
    private val queries: WordTableQueries = QueriesProvider.wordTableQueries,
) {

    fun insert(entity: WordDbEntity) {
        queries.insertItem(
            createdAt = entity.createdAt,
            wordText = entity.wordText,
            sortOrder = entity.sortOrder,
            maxRepeatCount = entity.maxRepeatCount,
            repeatCount = entity.maxRepeatCount,
        )
    }

    fun getWordsForStories(): Flow<List<WordDbEntity>> {
        return queries.selectAllForStories().asFlow().mapToList()
    }

    fun lastInsertedRowId(): Long {
        return queries.lastInsertRowId().executeAsOne()
    }

    fun executeWordsInTransaction(insertItems: TransactionWithoutReturn.() -> Unit) {
        queries.transaction {
            insertItems()
        }
    }
}