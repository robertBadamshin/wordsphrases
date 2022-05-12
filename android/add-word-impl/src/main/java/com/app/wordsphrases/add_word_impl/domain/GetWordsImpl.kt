package com.app.wordsphrases.add_word_impl.domain

import com.app.wordsphrases.add_word_api.GetWords
import com.app.wordsphrases.entity.word.Word
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class GetWordsImpl @Inject constructor(

) : GetWords {

    override operator fun invoke(): Flow<List<Word>> {
        return flowOf(emptyList())
    }
}