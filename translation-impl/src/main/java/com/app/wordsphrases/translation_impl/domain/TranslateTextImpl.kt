package com.app.wordsphrases.translation_impl.domain

import com.app.wordsphrases.entity.ResultWrapper
import com.app.wordsphrases.translation_api.TranslateText
import com.app.wordsphrases.translation_impl.data.TranslationRepository
import com.app.wordsphrases.translation_api.domain.TranslationResult
import javax.inject.Inject

class TranslateTextImpl @Inject constructor(
    private val translationRepository: TranslationRepository,
) : TranslateText {

    override suspend operator fun invoke(text: String): ResultWrapper<TranslationResult> {
        return translationRepository.translateText(text)
    }
}