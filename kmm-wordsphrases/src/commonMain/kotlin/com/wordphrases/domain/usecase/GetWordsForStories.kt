package com.wordphrases.domain.usecase

import com.wordphrases.data.repository.WordsRepository
import com.wordphrases.di.RepositoryProvider
import com.wordphrases.domain.entity.Word
import kotlinx.coroutines.flow.Flow

class GetWordsForStories(
    private val wordsRepository: WordsRepository = RepositoryProvider.wordsRepository,
) {

    operator fun invoke(languagePairId: Long): Flow<List<Word>> {
        return wordsRepository.getWordsForStories(languagePairId)
    }
}