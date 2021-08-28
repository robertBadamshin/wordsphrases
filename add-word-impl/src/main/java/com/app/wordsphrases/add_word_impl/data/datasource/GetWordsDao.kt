package com.app.wordsphrases.add_word_impl.data.datasource

import androidx.room.Dao
import androidx.room.Query
import com.app.wordsphrases.entity.word.WordDbEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GetWordsDao {

    @Query("Select * from word")
    fun getWords(): Flow<List<WordDbEntity>>
}