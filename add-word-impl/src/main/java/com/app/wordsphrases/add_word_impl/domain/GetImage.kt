package com.app.wordsphrases.add_word_impl.domain

import com.app.wordsphrases.add_word_impl.data.AddWordRepository
import com.app.wordsphrases.add_word_impl.domain.entity.WordImage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import javax.inject.Inject

class GetImage @Inject constructor(
    private val addWordRepository: AddWordRepository,
) {

    operator fun invoke(): Flow<WordImage> {
        return addWordRepository.getImage()
            .filterNotNull()
    }
}