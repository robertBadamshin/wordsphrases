package com.app.wordsphrases.popup_translator_impl.domain.use_case

import com.app.wordsphrases.entity.word.Word
import com.app.wordsphrases.stories_impl.data.repository.StoriesRepository
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class GetCurrentWord @Inject constructor(
    private val getCurrentWordPosition: GetCurrentWordPosition,
    private val storiesRepository: StoriesRepository,
) {

    operator fun invoke(): Flow<Word> {
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