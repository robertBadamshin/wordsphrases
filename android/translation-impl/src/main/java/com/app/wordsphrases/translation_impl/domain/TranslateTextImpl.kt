package com.app.wordsphrases.translation_impl.domain

import android.util.Log
import com.app.wordsphrases.entity.ResultWrapper
import com.app.wordsphrases.translation_api.TranslateText
import com.app.wordsphrases.translation_api.domain.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TranslateTextImpl @Inject constructor(
    private val translateTextByOxfordDictionary: TranslateTextByOxfordDictionary,
    private val translateTextByMicrosoft: TranslateTextByMicrosoft,
    private val countWordsInText: CountWordsInText,
) : TranslateText {

    // TODO make service and other
    override suspend operator fun invoke(text: String): ResultWrapper<TranslationResult> {
        val translationResult =TranslationResult(
            translations = listOf(
                Translation(1, "я"),
                Translation(1, "меня"),
            )
        )

        return ResultWrapper.createSuccess(translationResult)
//        return withContext(Dispatchers.IO) {
//            try {
//                val wordsCount = countWordsInText(text)
//                val result = if (wordsCount == 1) {
//                    translateTextByOxfordDictionary(text)
//                } else {
//                    translateTextByMicrosoft(text)
//                }
//                val formattedResult = formatTranslations(result)
//                ResultWrapper.createSuccess(formattedResult)
//            } catch (exception: Exception) {
//                Log.e("error", "error", exception)
//                ResultWrapper.createFailure(exception)
//            }
//        }
    }

    private fun formatTranslations(result: TranslationResult): TranslationResult {
        val translations = result.translations.map { translation ->
            val formattedText = translation.text.toLowerCase()
            translation.copy(text = formattedText)
        }

        return result.copy(translations = translations)
    }
}