package com.wordphrases.domain.usecase

import com.wordphrases.data.repository.WordsRepository
import com.wordphrases.di.RepositoryProvider
import com.wordphrases.domain.entity.Word

class UpdateWord(
    private val wordsRepository: WordsRepository = RepositoryProvider.wordsRepository,
) {

    operator fun invoke(
        existingWord: Word,
        wordText: String,
        comment: String?,
        translations: List<String>,
    ) {
        val word = Word(
            wordId = existingWord.wordId,
            languagePairId = existingWord.languagePairId,
            createdAt = existingWord.createdAt,
            wordText = wordText,
            sortOrder = existingWord.sortOrder,
            repeatCount = existingWord.repeatCount,
            maxRepeatCount = existingWord.maxRepeatCount,
            translations = translations,
            comment = comment,
        )

        wordsRepository.update(word)
    }
}