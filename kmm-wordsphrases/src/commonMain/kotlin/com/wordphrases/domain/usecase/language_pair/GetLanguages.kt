package com.wordphrases.domain.usecase.language_pair

import com.wordphrases.domain.entity.language.Language
import kotlinx.coroutines.flow.*

class GetLanguages {

    operator fun invoke(): Flow<List<Language>> {
        return flowOf(Language.values().toList())
    }
}