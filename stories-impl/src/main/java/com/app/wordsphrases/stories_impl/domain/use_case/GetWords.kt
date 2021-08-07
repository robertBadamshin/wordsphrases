package com.app.wordsphrases.stories_impl.domain.use_case

import com.app.wordsphrases.entity.word.Word
import com.app.wordsphrases.stories_impl.data.repository.StoriesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWords @Inject constructor(
    private val repository: StoriesRepository,
) {

    operator fun invoke(): Flow<List<Word>> {
        return repository.getWords()
    }
}