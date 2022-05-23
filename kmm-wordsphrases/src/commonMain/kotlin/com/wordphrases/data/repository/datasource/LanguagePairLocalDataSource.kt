package com.wordphrases.data.repository.datasource

import com.squareup.sqldelight.runtime.coroutines.*
import com.wordphrases.db.*
import com.wordphrases.di.QueriesProvider
import kotlinx.coroutines.flow.Flow

class LanguagePairLocalDataSource(
    private val queries: LanguagePairTableQueries = QueriesProvider.languagePairTableQueries,
) {

    fun insert(entity: LanguagePairDbEntity) {
        queries.insertItem(
            learningLanguageCode = entity.learningLanguageCode,
            nativeLanguageCode = entity.nativeLanguageCode,
            selected = entity.selected,
        )
    }

    fun getSelectedEntity(): Flow<LanguagePairDbEntity> {
        return queries.selectCurrentPair()
            .asFlow()
            .mapToOne()
    }

    fun requireSelectedEntity(): LanguagePairDbEntity {
        return queries.selectCurrentPair().executeAsOne()
    }

    fun getCurrentSelectedEntity(): LanguagePairDbEntity? {
        return queries.selectCurrentPair()
            .executeAsOneOrNull()
    }
}