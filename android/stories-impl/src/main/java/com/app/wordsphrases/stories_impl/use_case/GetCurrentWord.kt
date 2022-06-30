package com.app.wordsphrases.stories_impl.use_case

import com.app.wordsphrases.entity.word.WordOld
import com.app.wordsphrases.stories_impl.data.repository.StoriesRepository
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class GetCurrentWord @Inject constructor(
    private val getCurrentWordPosition: GetCurrentWordPosition,
    private val storiesRepository: StoriesRepository,
) {

    operator fun invoke(): Flow<WordOld> {
        return combine(
            getCurrentWordPosition(),
            storiesRepository.getWords(),
        ) { wordPosition, words ->
            return@combine if (words.isEmpty()) {
                null
            } else {
                words[wordPosition]
            }
        }
            .filterNotNull()
    }
}