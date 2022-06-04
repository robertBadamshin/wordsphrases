package com.app.wordsphrases.select_language_impl.data

import com.app.wordsphrases.core.di.FeatureScope
import com.wordphrases.domain.entity.language.Language
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@FeatureScope
class LanguagePairRepository @Inject constructor(

) {

    private val nativeLanguage = MutableStateFlow<Language?>(null)
    private val learningLanguage = MutableStateFlow<Language?>(null)

    fun setNativeLanguage(language: Language) {
        this.nativeLanguage.value = language
    }

    fun getNativeLanguage(): Flow<Language?> {
        return this.nativeLanguage
    }

    fun setLearningLanguage(language: Language) {
        this.learningLanguage.value = language
    }

    fun getLearningLanguage(): Flow<Language?> {
        return this.learningLanguage
    }
}