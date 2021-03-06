package com.app.wordsphrases.stories_impl.use_case

import com.app.wordsphrases.stories_impl.data.repository.StoriesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCurrentWordPosition @Inject constructor(
    private val repository: StoriesRepository,
) {

    operator fun invoke(): Flow<Int> {
        return repository.getWordPosition()
    }
}