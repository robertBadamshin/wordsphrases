package com.app.wordsphrases.add_word_impl.domain.use_case

import com.app.wordsphrases.add_word_impl.data.WordRepository
import com.app.wordsphrases.add_word_impl.domain.exception.TranslationsEmptyException
import com.app.wordsphrases.entity.*
import com.app.wordsphrases.translation_api.TranslateText
import com.app.wordsphrases.translation_api.domain.*
import com.wordphrases.ResultWrapper
import kotlinx.coroutines.flow.mapLatest
import javax.inject.Inject

class SubscribeForWordTranslation @Inject constructor(
    private val translateText: TranslateText,
    private val wordRepository: WordRepository,
) {

    suspend operator fun invoke() {
        wordRepository.getWordText()
            .mapLatest { word ->
                if (word.isNullOrBlank()) {
                    return@mapLatest null
                }

                wordRepository.setSelectedTranslationsIds(emptySet())
                wordRepository.setTranslations(RequestLoadingStateWrapper())
                val resultWrapper = translateText(text = word)

                return@mapLatest if (resultWrapper.isSuccess) {
                    handleSuccessResponse(resultWrapper)
                } else {
                    val exception = resultWrapper.requireException()
                    RequestErrorStateWrapper(exception)
                }
            }
            .collect { wrapper ->
                wordRepository.setTranslations(wrapper)
            }
    }

    private fun handleSuccessResponse(
        resultWrapper: ResultWrapper<TranslationResult>,
    ): RequestStateWrapper<List<Translation>> {
        val translationResult = resultWrapper.requireData()
        return if (translationResult.translations.isEmpty()) {
            RequestErrorStateWrapper(TranslationsEmptyException())
        } else {
            return RequestSuccessStateWrapper(translationResult.translations)
        }
    }
}