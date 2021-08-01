package com.app.wordsphrases.add_word_impl.data.datasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.app.wordsphrases.add_word_impl.data.entity.WordDbEntity

@Dao
interface WordDao {

    @Insert
    fun insertWord(word: WordDbEntity)

    @Query("Select * from word")
    fun getWords(): List<WordDbEntity>
}