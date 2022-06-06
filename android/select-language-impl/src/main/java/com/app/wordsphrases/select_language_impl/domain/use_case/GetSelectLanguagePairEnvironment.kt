package com.app.wordsphrases.select_language_impl.domain.use_case

import com.app.wordsphrases.select_language_impl.domain.entity.SelectLanguagePairEnvironment
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class GetSelectLanguagePairEnvironment @Inject constructor(
    private val getNativeLanguage: GetNativeLanguage,
    private val getLearningLanguage: GetLearningLanguage,
) {

    operator fun invoke(): Flow<SelectLanguagePairEnvironment> {
        return combine(
            getNativeLanguage(),
            getLearningLanguage(),
        ) { nativeLanguage, learningLanguage ->
            return@combine SelectLanguagePairEnvironment(
                nativeLanguage = nativeLanguage,
                learningLanguage = learningLanguage,
            )
        }
    }
}