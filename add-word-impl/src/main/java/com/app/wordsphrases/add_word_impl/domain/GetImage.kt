package com.app.wordsphrases.add_word_impl.domain

import com.app.wordsphrases.add_word_impl.data.WordRepository
import com.app.wordsphrases.add_word_api.WordImage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import javax.inject.Inject

// TODO cut image
class GetImage @Inject constructor(
    private val wordRepository: WordRepository,
) {

    operator fun invoke(): Flow<WordImage> {
        return wordRepository.getImage().filterNotNull()
    }
}