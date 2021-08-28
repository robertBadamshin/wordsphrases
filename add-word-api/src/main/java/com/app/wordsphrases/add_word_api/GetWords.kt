package com.app.wordsphrases.add_word_api

import com.app.wordsphrases.entity.word.Word
import kotlinx.coroutines.flow.Flow

interface GetWords {

    operator fun invoke(): Flow<List<Word>>
}