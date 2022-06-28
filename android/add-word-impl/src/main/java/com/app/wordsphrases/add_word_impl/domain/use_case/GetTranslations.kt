package com.app.wordsphrases.add_word_impl.domain.use_case

import com.app.wordsphrases.add_word_impl.data.AddWordRepository
import com.app.wordsphrases.add_word_impl.domain.entity.Translation
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTranslations @Inject constructor(
    private val addWordRepository: AddWordRepository,
) {

    operator fun invoke(): Flow<List<Translation>> {
        return addWordRepository.getTranslations()
    }
}