package com.wordphrases.data.repository.datasource

import com.squareup.sqldelight.TransactionWithoutReturn
import com.squareup.sqldelight.runtime.coroutines.*
import com.wordphrases.db.*
import com.wordphrases.di.QueriesProvider
import com.wordphrases.domain.entity.WordId
import kotlinx.coroutines.flow.Flow

class WordLocalDataSource(
    private val queries: WordTableQueries = QueriesProvider.wordTableQueries,
) {

    fun insert(entity: WordDbEntity) {
        queries.insertItem(
            languagePairId = entity.languagePairId,
            createdAt = entity.createdAt,
            wordText = entity.wordText,
            sortOrder = entity.sortOrder,
            maxRepeatCount = entity.maxRepeatCount,
            repeatCount = entity.maxRepeatCount,
            synced = entity.synced,
            comment = entity.comment,
        )
    }

    fun getAllWordsForDictionary(languagePairId: Long): Flow<List<WordDbEntity>> {
        return queries.getAllWordsForDictionary(languagePairId).asFlow().mapToList()
    }

    fun getWordById(wordId: WordId): WordDbEntity {
        return queries.getWordById(wordId).executeAsOne()
    }

    fun getWordsForSync(): List<WordDbEntity> {
        return queries.selectAllForSync().executeAsList()
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