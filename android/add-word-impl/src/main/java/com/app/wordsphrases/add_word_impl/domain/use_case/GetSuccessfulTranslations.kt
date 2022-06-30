package com.app.wordsphrases.add_word_impl.domain.use_case

import com.app.wordsphrases.add_word_impl.data.AddWordRepository
import com.app.wordsphrases.entity.RequestSuccessStateWrapper
import com.app.wordsphrases.translation_api.domain.Translation
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class GetSuccessfulTranslations @Inject constructor(
    private val addWordRepository: AddWordRepository,
) {

    operator fun invoke(): Flow<List<Translation>> {
        return addWordRepository.getTranslations()
            .filterIsInstance<RequestSuccessStateWrapper<List<Translation>>>()
            .map { wrapper -> wrapper.data }
    }
}