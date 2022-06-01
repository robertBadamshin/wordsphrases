package com.app.wordsphrases.add_word_impl.domain.use_case

import com.app.wordsphrases.add_word_impl.data.WordRepository
import com.app.wordsphrases.entity.RequestSuccessStateWrapper
import com.app.wordsphrases.translation_api.domain.Translation
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class GetSuccessfulTranslations @Inject constructor(
    private val wordRepository: WordRepository,
) {

    operator fun invoke(): Flow<List<Translation>> {
        return wordRepository.getTranslations()
            .filterIsInstance<RequestSuccessStateWrapper<List<Translation>>>()
            .map { wrapper -> wrapper.data }
    }
}