package com.app.wordsphrases.add_word_impl.domain.use_case

import com.app.wordsphrases.add_word_impl.data.WordRepository
import javax.inject.Inject

class SetSelectedTranslationsIds @Inject constructor(
    private val wordRepository: WordRepository,
){

    operator fun invoke(ids: Set<Int>) {
        wordRepository.setSelectedTranslationsIds(ids)
    }
}