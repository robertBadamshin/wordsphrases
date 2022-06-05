package com.app.wordsphrases.select_language_impl.domain.entity

import com.wordphrases.domain.entity.language.Language

data class SelectLanguageEnvironment(
    val selectedLanguage: Language?,
    val languages: List<Language>,
)