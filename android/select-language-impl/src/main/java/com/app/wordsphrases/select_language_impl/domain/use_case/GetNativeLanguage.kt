package com.app.wordsphrases.select_language_impl.domain.use_case

import com.app.wordsphrases.select_language_impl.data.LanguagePairRepository
import com.wordphrases.domain.entity.language.Language
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNativeLanguage @Inject constructor(
    private val languagePairRepository: LanguagePairRepository,
) {

    operator fun invoke(): Flow<Language?> {
        return languagePairRepository.getNativeLanguage()
    }
}
