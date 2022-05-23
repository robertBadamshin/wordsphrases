package com.wordphrases.domain.usecase.language_pair

import com.wordphrases.data.repository.LanguagePairRepository
import com.wordphrases.di.RepositoryProvider
import com.wordphrases.domain.entity.LanguagePair
import kotlinx.coroutines.flow.Flow

class GetSelectedLanguagePair(
    private val languagePairRepository: LanguagePairRepository = RepositoryProvider.languagePairRepository,
) {

    operator fun invoke(): Flow<LanguagePair> {
        return languagePairRepository.getSelectedLanguagePair()
    }
}