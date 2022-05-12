package com.wordphrases.domain.usecase

import com.wordphrases.data.repository.WordsRepository
import com.wordphrases.di.RepositoryProvider
import com.wordphrases.domain.entity.Word

class SaveNewWord(
    private val wordsRepository: WordsRepository = RepositoryProvider.wordsRepository
) {

    operator fun invoke(word: Word) {
        wordsRepository.save(word)
    }
}