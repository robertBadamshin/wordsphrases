package com.app.wordsphrases.add_word_impl.domain.use_case

import com.app.wordsphrases.add_word_impl.data.AddWordRepository
import com.app.wordsphrases.entity.RequestStateWrapper
import com.app.wordsphrases.translation_api.domain.Translation
import javax.inject.Inject

class GetCurrentTranslations @Inject constructor(
    private val addWordRepository: AddWordRepository,
) {

    operator fun invoke(): RequestStateWrapper<List<Translation>> {
        return addWordRepository.getCurrentTranslations()
    }
}