package com.app.wordsphrases.select_language_impl.data

import com.app.wordsphrases.core.di.FeatureScope
import com.wordphrases.domain.entity.language.Language
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@FeatureScope
class SelectLanguageRepository @Inject constructor() {

    private val selectedLanguageFlow = MutableStateFlow<Language?>(null)

    fun setSelectedLanguage(language: Language) {
        selectedLanguageFlow.value = language
    }

    fun getSelectedLanguage(): Flow<Language?> {
        return selectedLanguageFlow
    }
}