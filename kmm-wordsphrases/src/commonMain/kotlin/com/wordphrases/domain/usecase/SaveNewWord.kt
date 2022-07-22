package com.wordphrases.domain.usecase

import com.wordphrases.data.repository.WordsRepository
import com.wordphrases.di.RepositoryProvider
import com.wordphrases.domain.entity.*
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

        val allWordColorSchemes = WordColorSchema.values()
        val schemesCount = allWordColorSchemes.size
        val colorSchemeIndex = Random.nextInt(0, schemesCount)
        val wordColorScheme = allWordColorSchemes.get(colorSchemeIndex)

        val word = Word(
            languagePairId = languagePair.pairId,
            createdAt = currentTimeMilliseconds,
            wordText = wordText,
            sortOrder = Random.nextLong(),
            repeatCount = 0,
            maxRepeatCount = 4,
            translations = translations,
            comment = comment,
            colorSchema = wordColorScheme,
        )

        wordsRepository.save(word)
    }
}