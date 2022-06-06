package com.app.wordsphrases.select_language_impl.domain.use_case

import com.wordphrases.domain.entity.language.Language
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class GetLanguages @Inject constructor() {

    operator fun invoke(): Flow<List<Language>> {
        return flowOf(Language.values().toList())
    }
}