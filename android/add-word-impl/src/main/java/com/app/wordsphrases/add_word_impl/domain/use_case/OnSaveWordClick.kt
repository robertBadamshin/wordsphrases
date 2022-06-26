package com.app.wordsphrases.add_word_impl.domain.use_case

import com.app.wordsphrases.add_word_impl.data.WordRepository
import com.wordphrases.domain.usecase.SaveNewWord
import com.wordphrases.domain.usecase.language_pair.RequireSelectedLanguagePair
import javax.inject.Inject

private const val maxRepeatCount = 4L
private const val defaultRepeatCount = 0L

class OnSaveWordClick @Inject constructor(
    private val wordRepository: WordRepository,
    private val saveNewWord: SaveNewWord,
    private val getCurrentWordText: GetCurrentWordText,
    private val requireSelectedLanguagePair: RequireSelectedLanguagePair,
) {

    operator fun invoke() {
//        val wordText = getCurrentWordText()
//        // val selectedTranslationsTexts = selectedTranslations.map { translation -> translation.text }
//        val selectedLanguagePair = requireSelectedLanguagePair()
//
//        val word = Word(
//            languagePairId = selectedLanguagePair.pairId,
//            createdAt = System.currentTimeMillis(),
//            wordText = wordText,
//            sortOrder = Random.nextLong(),
//            maxRepeatCount = maxRepeatCount,
//            repeatCount = defaultRepeatCount,
//            translations = selectedTranslationsTexts,
//        )
//
//        saveNewWord(word)
    }
}