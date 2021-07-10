package com.app.wordsphrases.add_word_impl.data.datasource

import androidx.room.Insert
import androidx.room.Query
import com.app.wordsphrases.add_word_impl.data.entity.WordDbEntity

interface WordDao {

    @Insert
    fun insertWord(word: WordDbEntity)

}