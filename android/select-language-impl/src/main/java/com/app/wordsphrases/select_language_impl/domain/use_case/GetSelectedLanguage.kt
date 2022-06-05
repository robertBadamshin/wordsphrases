package com.app.wordsphrases.select_language_impl.domain.use_case

import com.app.wordsphrases.select_language_impl.data.SelectLanguageRepository
import com.wordphrases.domain.entity.language.Language
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSelectedLanguage @Inject constructor(
    private val selectLanguageRepository: SelectLanguageRepository,
) {

    operator fun invoke(): Flow<Language?> {
        return selectLanguageRepository.getSelectedLanguage()
    }
}