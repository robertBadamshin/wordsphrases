package com.app.wordsphrases.add_word_impl.domain

import com.app.wordsphrases.add_word_impl.data.WordRepository
import com.app.wordsphrases.entity.RequestStateWrapper
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTranslations @Inject constructor(
    private val wordRepository: WordRepository,
) {

    operator fun invoke(): Flow<RequestStateWrapper<List<String>>?> {
        return wordRepository.getTranslations()
    }
}