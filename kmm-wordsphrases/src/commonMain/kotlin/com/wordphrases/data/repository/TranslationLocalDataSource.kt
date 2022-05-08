package com.wordphrases.data.repository

import com.wordphrases.db.*
import com.wordphrases.di.QueriesProvider

class TranslationLocalDataSource(
    private val queries: TranslationTableQueries = QueriesProvider.translationTableQueries,
) {

    fun insert(entity: TranslationDbEntity) {
        queries.insertItem(
            transaltionId = entity.transaltionId,
            wordId = entity.wordId,
            transaltionText = entity.transaltionText,
        )
    }

    fun getEntities(): List<TranslationDbEntity> {
        return queries.selectAll().executeAsList()
    }
}