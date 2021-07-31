package com.app.wordsphrases.translation_impl.domain

import com.app.wordsphrases.entity.ResultWrapper
import com.app.wordsphrases.translation_api.TranslateText
import com.app.wordsphrases.translation_api.domain.TranslationResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TranslateTextImpl @Inject constructor(
    private val translateTextByMicrosoft: TranslateTextByMicrosoft,
) : TranslateText {

    // TODO make service and other
    override suspend operator fun invoke(text: String): ResultWrapper<TranslationResult> {
        return withContext(Dispatchers.IO) {
            try {
                val result = translateTextByMicrosoft(text)
                val formattedResult = formatTranslations(result)
                ResultWrapper.createSuccess(formattedResult)
            } catch (exception: Exception) {
                ResultWrapper.createFailure(exception)
            }
        }
    }

    private fun formatTranslations(result: TranslationResult): TranslationResult {
        val translations = result.translations.map { translation ->
            val formattedText = translation.text.toLowerCase()
            translation.copy(text = formattedText)
        }

        return result.copy(translations = translations)
    }
}