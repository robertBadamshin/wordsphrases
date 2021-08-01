package com.app.wordsphrases.add_word_impl.domain

import com.app.wordsphrases.add_word_api.SaveWord
import com.app.wordsphrases.add_word_api.WordImage
import com.app.wordsphrases.add_word_impl.data.SaveWordRepository
import com.app.wordsphrases.entity.ResultWrapper
import javax.inject.Inject

class SaveWordImpl @Inject constructor(
    private val saveWordRepository: SaveWordRepository,
) : SaveWord {

    override suspend fun invoke(text: String, translation: String, image: WordImage?): ResultWrapper<Unit> {
        return saveWordRepository.addWord(text, translation, image)
    }
}