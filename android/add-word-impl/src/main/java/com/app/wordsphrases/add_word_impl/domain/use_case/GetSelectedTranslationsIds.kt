package com.app.wordsphrases.add_word_impl.domain.use_case

import com.app.wordsphrases.add_word_impl.data.AddWordRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSelectedTranslationsIds @Inject constructor(
    private val addWordRepository: AddWordRepository,
) {

    operator fun invoke(): Flow<Set<Int>> {
        return addWordRepository.getSelectedTranslationsIds()
    }
}