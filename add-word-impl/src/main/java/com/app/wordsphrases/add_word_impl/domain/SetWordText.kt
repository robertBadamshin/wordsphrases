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

class SetWordText @Inject constructor(
    private val wordRepository: WordRepository,
) {

    operator fun invoke(text: String) {
        wordRepository.setWordText(text)
    }
}