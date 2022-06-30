package com.app.wordsphrases.add_word_impl.domain.use_case

import com.app.wordsphrases.add_word_impl.data.AddWordRepository
import com.app.wordsphrases.add_word_impl.domain.exception.TranslationsEmptyException
import com.app.wordsphrases.entity.*
import com.app.wordsphrases.translation_api.TranslateText
import com.app.wordsphrases.translation_api.domain.*
import com.wordphrases.ResultWrapper
import kotlinx.coroutines.flow.mapLatest
import javax.inject.Inject

class SubscribeForWordTranslation @Inject constructor(
    private val translateText: TranslateText,
    private val addWordRepository: AddWordRepository,
) {

    suspend operator fun invoke() {
        addWordRepository.getWordText()
            .mapLatest { word ->
                if (word.isNullOrBlank()) {
                    return@mapLatest null
                }

                addWordRepository.setSelectedTranslationsIds(emptySet())
                addWordRepository.setTranslations(RequestLoadingStateWrapper())
                val resultWrapper = translateText(text = word)

                return@mapLatest if (resultWrapper.isSuccess) {
                    handleSuccessResponse(resultWrapper)
                } else {
                    val exception = resultWrapper.requireException()
                    RequestErrorStateWrapper(exception)
                }
            }
            .collect { wrapper ->
                addWordRepository.setTranslations(wrapper)
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