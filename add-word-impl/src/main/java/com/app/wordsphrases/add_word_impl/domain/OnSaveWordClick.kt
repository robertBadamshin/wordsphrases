package com.app.wordsphrases.add_word_impl.domain

import com.app.wordsphrases.add_word_api.SaveWord
import com.app.wordsphrases.add_word_impl.data.WordRepository
import com.app.wordsphrases.entity.RequestErrorStateWrapper
import com.app.wordsphrases.entity.RequestSuccessStateWrapper
import javax.inject.Inject

class OnSaveWordClick @Inject constructor(
    private val wordRepository: WordRepository,
    private val saveWord: SaveWord,
    private val getCurrentImage: GetCurrentImage,
) {

    suspend operator fun invoke(text: String, translation: String) {
        val image = getCurrentImage()
        val result = saveWord(text, translation, image)

        if (result.isSuccess) {
            wordRepository.setCreationResult(RequestSuccessStateWrapper(data = Unit))
        } else {
            wordRepository.setCreationResult(RequestErrorStateWrapper(throwable = result.requireException()))
        }
    }
}