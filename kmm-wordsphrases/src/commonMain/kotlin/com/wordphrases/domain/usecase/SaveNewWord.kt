package com.wordphrases.domain.usecase

import com.wordphrases.data.repository.WordsRepository
import com.wordphrases.di.RepositoryProvider
import com.wordphrases.domain.entity.Word
import com.wordphrases.domain.usecase.language_pair.RequireSelectedLanguagePair
import kotlin.random.Random

class SaveNewWord(
    private val wordsRepository: WordsRepository = RepositoryProvider.wordsRepository,
    private val requireSelectedLanguagePair: RequireSelectedLanguagePair = RequireSelectedLanguagePair(),
) {

    operator fun invoke(
        wordText: String,
        currentTimeMilliseconds: Long,
        comment: String?,
        translations: List<String>,
    ) {
        val languagePair = requireSelectedLanguagePair()
        val word = Word(
            languagePairId = languagePair.pairId,
            createdAt = currentTimeMilliseconds,
            wordText = wordText,
            sortOrder = Random.nextLong(),
            repeatCount = 0,
            maxRepeatCount = 4,
            translations = translations,
            comment = comment,
        )

        wordsRepository.save(word)
    }
}