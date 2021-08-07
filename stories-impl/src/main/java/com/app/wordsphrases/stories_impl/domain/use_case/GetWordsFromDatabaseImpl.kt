package com.app.wordsphrases.stories_impl.domain.use_case

import com.app.wordsphrases.entity.word.Word
import com.app.wordsphrases.stories_api.GetWordsFromDatabase
import com.app.wordsphrases.stories_impl.data.repository.GetWordsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWordsFromDatabaseImpl @Inject constructor(
    private val repository: GetWordsRepository,
) : GetWordsFromDatabase {

    override operator fun invoke(): Flow<List<Word>> {
        return repository.subscribeForWords()
    }
}