package com.app.wordsphrases.add_word_impl.domain

import com.app.wordsphrases.add_word_impl.data.AddWordRepository
import com.app.wordsphrases.entity.RequestErrorStateWrapper
import com.app.wordsphrases.entity.RequestLoadingStateWrapper
import com.app.wordsphrases.entity.RequestSuccessStateWrapper
import com.app.wordsphrases.entity.mapData
import com.app.wordsphrases.translation_api.TranslateText
import javax.inject.Inject

class OnTranslateTextClick @Inject constructor(
    private val translateText: TranslateText,
    private val addWordRepository: AddWordRepository,
) {

    suspend operator fun invoke(text: String) {
        addWordRepository.setTranslations(RequestLoadingStateWrapper())
        val resultWrapper = translateText(text = text)

        if (resultWrapper.isSuccess) {
            val translationResult = resultWrapper.requireData()
            val resultSuccessWrapper = RequestSuccessStateWrapper(translationResult.translations)
            val translations = resultSuccessWrapper.mapData { data ->
                data.map { translationItem -> translationItem.text }
            }
            addWordRepository.setTranslations(translations)
        } else {
            val exception = resultWrapper.requireException()
            val resultErrorWrapper = RequestErrorStateWrapper<List<String>>(exception)
            addWordRepository.setTranslations(resultErrorWrapper)
        }
    }
}