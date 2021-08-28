package com.app.wordsphrases.add_word_impl.data.datasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.app.wordsphrases.entity.word.WordDbEntity

@Dao
interface InsertWordDao {

    @Insert
    fun insertWord(word: WordDbEntity): Long

    @Query("Select * from word")
    fun getWords(): List<WordDbEntity>
}