package com.app.wordsphrases.add_word_impl.domain

import com.app.wordsphrases.add_word_api.GetWords
import com.app.wordsphrases.add_word_impl.data.GetWordsRepository
import com.app.wordsphrases.entity.word.Word
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWordsImpl @Inject constructor(
    private val repository: GetWordsRepository,
) : GetWords {

    override operator fun invoke(): Flow<List<Word>> {
        return repository.getWords()
    }
}