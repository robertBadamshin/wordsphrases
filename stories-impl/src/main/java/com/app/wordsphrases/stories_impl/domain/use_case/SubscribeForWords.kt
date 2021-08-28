package com.app.wordsphrases.stories_impl.domain.use_case

import com.app.wordsphrases.add_word_api.GetWords
import com.app.wordsphrases.stories_impl.data.repository.StoriesRepository
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class SubscribeForWords @Inject constructor(
    private val getWords: GetWords,
    private val repository: StoriesRepository,
) {

    suspend operator fun invoke() {
        return getWords()
            .collect { words -> repository.setWords(words) }
    }
}