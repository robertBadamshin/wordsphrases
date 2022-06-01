package com.app.wordsphrases.stories_impl.use_case

import com.app.wordsphrases.stories_impl.data.repository.StoriesRepository
import javax.inject.Inject

private const val firstWordIndex = 0

class MoveToNextWord @Inject constructor(
    private val repository: StoriesRepository,
) {

    operator fun invoke() {
        val words = repository.getCurrentsWords()
        val position = repository.getCurrentWordPosition()

        val newPosition = if (words.isEmpty() || words.lastIndex == position) {
            firstWordIndex
        } else {
            position + 1
        }

        repository.setWordPosition(newPosition)
    }
}