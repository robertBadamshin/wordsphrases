package com.app.wordsphrases.translation_api

import com.app.wordsphrases.entity.ResultWrapper
import com.app.wordsphrases.translation_api.domain.TranslationResult

interface TranslateText {

    suspend operator fun invoke(text: String): ResultWrapper<TranslationResult>
}