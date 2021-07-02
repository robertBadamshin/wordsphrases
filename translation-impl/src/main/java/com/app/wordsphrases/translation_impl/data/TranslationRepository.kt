package com.app.wordsphrases.translation_impl.data

import com.app.wordsphrases.entity.ResultWrapper
import com.app.wordsphrases.translation_impl.datasource.TranslationDataSource
import com.app.wordsphrases.translation_api.domain.TranslationResult
import javax.inject.Inject

class TranslationRepository @Inject constructor(
    private val translationDataSource: TranslationDataSource,
) {

    suspend fun translateText(text: String): ResultWrapper<TranslationResult> {
        return translationDataSource.getTranslation(text = text)
    }
}