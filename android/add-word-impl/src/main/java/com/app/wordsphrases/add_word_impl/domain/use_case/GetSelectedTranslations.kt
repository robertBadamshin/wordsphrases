package com.app.wordsphrases.add_word_impl.domain.use_case

import com.app.wordsphrases.entity.RequestSuccessStateWrapper
import com.app.wordsphrases.translation_api.domain.Translation
import javax.inject.Inject

class GetSelectedTranslations @Inject constructor(
    private val requireSelectedTranslationsIds: RequireSelectedTranslationsIds,
    private val getCurrentTranslations: GetCurrentTranslations,
) {

    operator fun invoke(): List<Translation> {
        val ids = requireSelectedTranslationsIds()
        val currentTranslationsWrapper = getCurrentTranslations()

        if (currentTranslationsWrapper is RequestSuccessStateWrapper) {
            val translations = currentTranslationsWrapper.data
            return translations.filter { translation -> ids.contains(translation.id) }
        }

        throw IllegalStateException("should only be success")
    }
}