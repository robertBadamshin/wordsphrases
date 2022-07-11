package com.wordphrases.domain.usecase.word

import com.wordphrases.data.repository.WordsRepository
import com.wordphrases.di.RepositoryProvider
import com.wordphrases.domain.entity.*

class GetWordById(
    private val wordsRepository: WordsRepository = RepositoryProvider.wordsRepository,
) {

    operator fun invoke(wordId: WordId): Word {
        return wordsRepository.getWordById(wordId)
    }
}