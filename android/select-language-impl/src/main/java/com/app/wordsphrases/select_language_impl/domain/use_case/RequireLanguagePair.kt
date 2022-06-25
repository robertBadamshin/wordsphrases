package com.app.wordsphrases.select_language_impl.domain.use_case

import com.app.wordsphrases.select_language_impl.data.LanguagePairRepository
import com.wordphrases.domain.entity.LanguagePair
import javax.inject.Inject

class RequireLanguagePair @Inject constructor(
    private val languagePairRepository: LanguagePairRepository,
) {

    operator fun invoke(): LanguagePair {
        val nativeLanguage = languagePairRepository.requireNativeLanguage()
        val learningLanguage = languagePairRepository.requireLearningLanguage()

        return LanguagePair(
            learningLanguageCode = learningLanguage.name,
            nativeLanguageCode = nativeLanguage.name,
            selected = true,
        )
    }
}