package com.app.wordsphrases.add_word_impl.domain

import com.app.wordsphrases.add_word_impl.data.WordRepository
import com.app.wordsphrases.entity.RequestErrorStateWrapper
import com.app.wordsphrases.entity.RequestLoadingStateWrapper
import com.app.wordsphrases.entity.RequestStateWrapper
import com.app.wordsphrases.entity.RequestSuccessStateWrapper
import com.app.wordsphrases.entity.mapData
import com.app.wordsphrases.translation_api.domain.Translation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.map
import java.lang.IllegalStateException
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