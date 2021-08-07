package com.app.wordsphrases.stories_impl.data.repository

import com.app.wordsphrases.core.di.AppScope
import com.app.wordsphrases.core.di.FeatureScope
import com.app.wordsphrases.entity.word.Word
import com.app.wordsphrases.entity.word.toDomainEntity
import com.app.wordsphrases.stories_impl.data.datasource.GetWordsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AppScope
class GetWordsRepository @Inject constructor(
    private val getWordsDao: GetWordsDao,
) {

    fun subscribeForWords(): Flow<List<Word>> {
        return getWordsDao.getWords().map { wordDbEntities ->
            wordDbEntities.map { wordDbEntity -> wordDbEntity.toDomainEntity() }
        }
    }
}