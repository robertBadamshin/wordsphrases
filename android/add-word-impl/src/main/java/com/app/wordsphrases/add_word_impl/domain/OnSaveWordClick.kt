package com.app.wordsphrases.add_word_impl.domain

import com.app.wordsphrases.add_word_impl.data.WordRepository
import com.app.wordsphrases.entity.RequestSuccessStateWrapper
import com.wordphrases.domain.entity.Word
import com.wordphrases.domain.usecase.SaveNewWord
import javax.inject.Inject
import kotlin.random.Random

private const val maxRepeatCount = 4L
private const val defaultRepeatCount = 0L

class OnSaveWordClick @Inject constructor(
    private val wordRepository: WordRepository,
    private val saveNewWord: SaveNewWord,
    private val getCurrentImage: GetCurrentImage,
    private val getCurrentWordText: GetCurrentWordText,
    private val getSelectedTranslations: GetSelectedTranslations,
) {

    suspend operator fun invoke() {
        val image = getCurrentImage()
        val wordText = getCurrentWordText()
        val selectedTranslations = getSelectedTranslations()
        val selectedTranslationsTexts = selectedTranslations.map { translation -> translation.text }

        val word = Word(
            createdAt = System.currentTimeMillis(),
            wordText = wordText,
            sortOrder = Random.nextLong(),
            maxRepeatCount = maxRepeatCount,
            repeatCount = defaultRepeatCount,
            translations = selectedTranslationsTexts,
        )

        val result = saveNewWord(word)
        //if (result.isSuccess) {
            wordRepository.setCreationResult(RequestSuccessStateWrapper(data = Unit))
//        } else {
//            wordRepository.setCreationResult(RequestErrorStateWrapper(throwable = result.requireException()))
//        }
    }
}