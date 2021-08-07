package com.app.wordsphrases.stories_api

import com.app.wordsphrases.entity.word.Word
import kotlinx.coroutines.flow.Flow

interface GetWordsFromDatabase {

    operator fun invoke(): Flow<List<Word>>
}