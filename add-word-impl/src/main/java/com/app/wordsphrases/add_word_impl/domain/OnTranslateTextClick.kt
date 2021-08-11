package com.app.wordsphrases.add_word_impl.domain

import com.app.wordsphrases.add_word_impl.data.WordRepository
import com.app.wordsphrases.add_word_impl.domain.exception.TranslationsEmptyException
import com.app.wordsphrases.entity.RequestErrorStateWrapper
import com.app.wordsphrases.entity.RequestLoadingStateWrapper
import com.app.wordsphrases.entity.RequestSuccessStateWrapper
import com.app.wordsphrases.entity.ResultWrapper
import com.app.wordsphrases.entity.mapData
import com.app.wordsphrases.translation_api.TranslateText
import com.app.wordsphrases.translation_api.domain.TranslationResult
import javax.inject.Inject

class OnTranslateTextClick @Inject constructor(
    private val translateText: TranslateText,
    private val wordRepository: WordRepository,
) {

    suspend operator fun invoke(text: String) {
        wordRepository.setTranslations(RequestLoadingStateWrapper())
        val resultWrapper = translateText(text = text)

        if (resultWrapper.isSuccess) {
            handleSuccessResponse(resultWrapper)
        } else {
            val exception = resultWrapper.requireException()
            val resultErrorWrapper = RequestErrorStateWrapper<List<String>>(exception)
            wordRepository.setTranslations(resultErrorWrapper)
        }
    }

    private suspend fun handleSuccessResponse(resultWrapper: ResultWrapper<TranslationResult>) {
        val translationResult = resultWrapper.requireData()
        if (translationResult.translations.isEmpty()) {
            val resultErrorWrapper = RequestErrorStateWrapper<List<String>>(TranslationsEmptyException())
            wordRepository.setTranslations(resultErrorWrapper)
        } else {
            val resultSuccessWrapper = RequestSuccessStateWrapper(translationResult.translations)
            val translations = resultSuccessWrapper.mapData { data ->
                data.map { translationItem -> translationItem.text }
            }
            wordRepository.setTranslations(translations)
        }
    }
}