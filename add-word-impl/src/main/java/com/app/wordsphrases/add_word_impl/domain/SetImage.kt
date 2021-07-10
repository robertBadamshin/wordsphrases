package com.app.wordsphrases.add_word_impl.domain

import com.app.wordsphrases.add_word_impl.data.AddWordRepository
import com.app.wordsphrases.add_word_impl.domain.entity.WordImage
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SetImage @Inject constructor(
    private val addWordRepository: AddWordRepository,
) {

    operator fun invoke(image: WordImage?) {
        addWordRepository.setImage(image)
    }
}