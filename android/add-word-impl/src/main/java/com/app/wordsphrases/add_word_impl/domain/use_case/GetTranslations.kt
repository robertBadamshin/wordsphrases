package com.app.wordsphrases.add_word_impl.domain.use_case

import com.app.wordsphrases.add_word_impl.data.WordRepository
import com.app.wordsphrases.add_word_impl.domain.entity.Translation
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTranslations @Inject constructor(
    private val wordRepository: WordRepository,
) {

    operator fun invoke(): Flow<List<Translation>> {
        return wordRepository.getTranslations()
    }
}