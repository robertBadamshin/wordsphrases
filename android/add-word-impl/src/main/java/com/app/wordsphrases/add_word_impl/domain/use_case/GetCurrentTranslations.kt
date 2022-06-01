package com.app.wordsphrases.add_word_impl.domain.use_case

import com.app.wordsphrases.add_word_impl.data.WordRepository
import com.app.wordsphrases.entity.RequestStateWrapper
import com.app.wordsphrases.translation_api.domain.Translation
import javax.inject.Inject

class GetCurrentTranslations @Inject constructor(
    private val wordRepository: WordRepository,
) {

    operator fun invoke(): RequestStateWrapper<List<Translation>> {
        return wordRepository.getCurrentTranslations()
    }
}