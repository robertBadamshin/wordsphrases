package com.app.wordsphrases.stories_impl.domain.use_case

import com.app.wordsphrases.entity.word.Word
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filterNotNull
import javax.inject.Inject

class GetCurrentWord @Inject constructor(
    private val getCurrentWordPosition: GetCurrentWordPosition,
    private val getWords: GetWords,
) {

    operator fun invoke(): Flow<Word> {
        return combine(
            getCurrentWordPosition(),
            getWords(),
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