package com.app.wordsphrases.add_word_impl.domain.use_case

import com.app.wordsphrases.add_word_api.WordImage
import com.app.wordsphrases.add_word_impl.data.WordRepository
import kotlinx.coroutines.flow.*
import javax.inject.Inject

// TODO cut image
class GetImage @Inject constructor(
    private val wordRepository: WordRepository,
) {

    operator fun invoke(): Flow<WordImage> {
        return wordRepository.getImage().filterNotNull()
    }
}