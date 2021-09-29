package com.app.wordsphrases.add_word_impl.domain

import com.app.wordsphrases.add_word_impl.data.AddWordComponentsRepository
import javax.inject.Inject

class ClearPopupAddWordComponent @Inject constructor(
    private val addWordComponentsRepository: AddWordComponentsRepository,
) {

    operator fun invoke() {
        addWordComponentsRepository.clearPopupAddWordComponent()
    }
}