package com.app.wordsphrases.add_word_impl.domain

import com.app.wordsphrases.add_word_impl.data.WordRepository
import com.app.wordsphrases.entity.RequestErrorStateWrapper
import com.app.wordsphrases.entity.RequestSuccessStateWrapper
import javax.inject.Inject

class OnSaveWordClick @Inject constructor(
    private val wordRepository: WordRepository,
    private val saveWord: SaveWord,
    private val getCurrentImage: GetCurrentImage,
    private val getCurrentWordText: GetCurrentWordText,
    private val getSelectedTranslations: GetSelectedTranslations,
) {

    suspend operator fun invoke() {
        val image = getCurrentImage()
        val wordText = getCurrentWordText()
        val selectedTranslations = getSelectedTranslations()
        val selectedTranslationsTexts = selectedTranslations.map { translation -> translation.text }

        val result = saveWord(wordText, selectedTranslationsTexts, image)
        if (result.isSuccess) {
            wordRepository.setCreationResult(RequestSuccessStateWrapper(data = Unit))
        } else {
            wordRepository.setCreationResult(RequestErrorStateWrapper(throwable = result.requireException()))
        }
    }
}