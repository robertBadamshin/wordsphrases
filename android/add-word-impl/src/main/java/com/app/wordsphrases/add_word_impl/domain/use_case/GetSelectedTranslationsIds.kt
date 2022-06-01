package com.app.wordsphrases.add_word_impl.domain.use_case

import com.app.wordsphrases.add_word_impl.data.WordRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSelectedTranslationsIds @Inject constructor(
    private val wordRepository: WordRepository,
) {

    operator fun invoke(): Flow<Set<Int>> {
        return wordRepository.getSelectedTranslationsIds()
    }
}