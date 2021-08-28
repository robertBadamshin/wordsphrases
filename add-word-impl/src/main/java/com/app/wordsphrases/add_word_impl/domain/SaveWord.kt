package com.app.wordsphrases.add_word_impl.domain

import com.app.wordsphrases.add_word_api.WordImage
import com.app.wordsphrases.add_word_impl.data.SaveWordRepository
import com.app.wordsphrases.entity.ResultWrapper
import javax.inject.Inject

class SaveWord @Inject constructor(
    private val saveWordRepository: SaveWordRepository,
) {

    suspend operator fun invoke(text: String, translations: List<String>, image: WordImage?): ResultWrapper<Long> {
        return saveWordRepository.addWord(text, translations, image)
    }
}