package com.app.wordsphrases.translation_api

import com.app.wordsphrases.translation_api.domain.TranslationResult
import com.wordphrases.ResultWrapper

interface TranslateText {

    suspend operator fun invoke(text: String): ResultWrapper<TranslationResult>
}