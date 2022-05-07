package com.app.wordsphrases.add_word_impl.data

import com.app.wordsphrases.add_word_impl.data.datasource.GetWordsDao
import com.app.wordsphrases.core.di.AppScope
import com.app.wordsphrases.entity.word.Word
import com.app.wordsphrases.entity.word.toDomainEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


@AppScope
class GetWordsRepository @Inject constructor(
    private val getWordsDao: GetWordsDao,
) {

    fun getWords(): Flow<List<Word>> {
        return getWordsDao.getWords().map { wordDbEntities ->
            wordDbEntities.map { wordDbEntity -> wordDbEntity.toDomainEntity() }
        }
    }
}