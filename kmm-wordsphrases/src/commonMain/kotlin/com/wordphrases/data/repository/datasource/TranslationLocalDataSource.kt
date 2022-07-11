package com.wordphrases.data.repository.datasource

import com.squareup.sqldelight.TransactionWithoutReturn
import com.squareup.sqldelight.runtime.coroutines.*
import com.wordphrases.db.*
import com.wordphrases.di.QueriesProvider
import com.wordphrases.domain.entity.WordId
import kotlinx.coroutines.flow.Flow

class TranslationLocalDataSource(
    private val queries: TranslationTableQueries = QueriesProvider.translationTableQueries,
) {

    fun insert(entity: TranslationDbEntity) {
        queries.insertItem(
            wordId = entity.wordId,
            transaltionText = entity.transaltionText,
        )
    }

    fun getTranslationsForWords(wordsIds: List<WordId>): Flow<List<TranslationDbEntity>> {
        return queries.selectAll(wordsIds).asFlow().mapToList()
    }

    fun getTranslationsForWord(wordId: WordId): List<TranslationDbEntity> {
        return queries.selectAllForWord(wordId).executeAsList()
    }

    fun executeTranslationsInTransaction(insertItems: TransactionWithoutReturn.() -> Unit) {
        queries.transaction {
            insertItems()
        }
    }
}