package com.app.wordsphrases.add_word_impl.domain

import com.app.wordsphrases.add_word_impl.data.WordRepository
import com.app.wordsphrases.entity.RequestErrorStateWrapper
import com.app.wordsphrases.entity.RequestLoadingStateWrapper
import com.app.wordsphrases.entity.RequestSuccessStateWrapper
import com.app.wordsphrases.entity.mapData
import com.app.wordsphrases.translation_api.TranslateText
import javax.inject.Inject

class OnTranslateTextClick @Inject constructor(
    private val translateText: TranslateText,
    private val wordRepository: WordRepository,
) {

    suspend operator fun invoke(text: String) {
        wordRepository.setTranslations(RequestLoadingStateWrapper())
        val resultWrapper = translateText(text = text)

        if (resultWrapper.isSuccess) {
            val translationResult = resultWrapper.requireData()
            val resultSuccessWrapper = RequestSuccessStateWrapper(translationResult.translations)
            val translations = resultSuccessWrapper.mapData { data ->
                data.map { translationItem -> translationItem.text }
            }
            wordRepository.setTranslations(translations)
        } else {
            val exception = resultWrapper.requireException()
            val resultErrorWrapper = RequestErrorStateWrapper<List<String>>(exception)
            wordRepository.setTranslations(resultErrorWrapper)
        }
    }
}