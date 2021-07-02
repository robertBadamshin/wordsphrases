package com.app.wordsphrases.translation_impl.datasource

import com.app.wordsphrases.entity.ResultWrapper
import com.app.wordsphrases.entity.mapData
import com.app.wordsphrases.translation_impl.data.entity.toDomainEntity
import com.app.wordsphrases.translation_impl.data.service.TranslationService
import com.app.wordsphrases.translation_api.domain.TranslationResult
import javax.inject.Inject

class TranslationDataSource @Inject constructor(
    private val translationService: TranslationService,
) {

    suspend fun getTranslation(text: String): ResultWrapper<TranslationResult> {
        return translationService.getTranslation(text = text)
            .mapData { translationResultRemote -> translationResultRemote.toDomainEntity() }
    }
}