package com.app.wordsphrases.add_word_impl.domain.use_case

import com.app.wordsphrases.add_word_impl.data.AddWordRepository
import com.app.wordsphrases.entity.RequestSuccessStateWrapper
import com.wordphrases.domain.entity.Word
import com.wordphrases.domain.usecase.SaveNewWord
import com.wordphrases.domain.usecase.language_pair.RequireSelectedLanguagePair
import javax.inject.Inject
import kotlin.random.Random

private const val maxRepeatCount = 4L
private const val defaultRepeatCount = 0L

class OnSaveWordClick @Inject constructor(
    private val addWordRepository: AddWordRepository,
    private val saveNewWord: SaveNewWord,
    private val getCurrentImage: GetCurrentImage,
    private val getCurrentWordText: GetCurrentWordText,
    private val getSelectedTranslations: GetSelectedTranslations,
    private val requireSelectedLanguagePair: RequireSelectedLanguagePair,
) {

    operator fun invoke() {
        val wordText = getCurrentWordText()
        val selectedTranslations = getSelectedTranslations()
        val selectedTranslationsTexts = selectedTranslations.map { translation -> translation.text }
        val selectedLanguagePair = requireSelectedLanguagePair()

        val word = Word(
            languagePairId = selectedLanguagePair.pairId,
            createdAt = System.currentTimeMillis(),
            wordText = wordText,
            sortOrder = Random.nextLong(),
            maxRepeatCount = maxRepeatCount,
            repeatCount = defaultRepeatCount,
            translations = selectedTranslationsTexts,
        )

        saveNewWord(word)
        addWordRepository.setCreationResult(RequestSuccessStateWrapper(data = Unit))
    }
}