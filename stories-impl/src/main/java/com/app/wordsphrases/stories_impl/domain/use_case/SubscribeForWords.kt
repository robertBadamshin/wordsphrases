package com.app.wordsphrases.stories_impl.domain.use_case

import com.app.wordsphrases.stories_api.GetWordsFromDatabase
import com.app.wordsphrases.stories_impl.data.repository.StoriesRepository
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class SubscribeForWords @Inject constructor(
    private val getWordsFromDatabase: GetWordsFromDatabase,
    private val repository: StoriesRepository,
) {

    suspend operator fun invoke() {
        return getWordsFromDatabase()
            .collect { words -> repository.setWords(words) }
    }
}