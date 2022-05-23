package com.wordphrases.domain.usecase.language_pair

import com.wordphrases.data.repository.LanguagePairRepository
import com.wordphrases.di.RepositoryProvider
import com.wordphrases.domain.entity.LanguagePair

class CreateDefaultLanguagePair(
    private val languagePairRepository: LanguagePairRepository = RepositoryProvider.languagePairRepository,
) {

    operator fun invoke() {
        val languagePair = LanguagePair(
            learningLanguageCode = "EN",
            nativeLanguageCode = "RU",
            selected = true,
        )
        languagePairRepository.save(languagePair)
    }
}