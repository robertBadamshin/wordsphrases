package com.app.wordsphrases.add_word_impl.domain

import com.app.wordsphrases.add_word_impl.data.AddWordComponentsRepository
import com.app.wordsphrases.add_word_api.domain.entity.AddWordComponentType
import javax.inject.Inject

class ClearAddWordComponent @Inject constructor(
    private val addWordComponentsRepository: AddWordComponentsRepository,
) {

    operator fun invoke(type: AddWordComponentType) {
        addWordComponentsRepository.clearAddWordComponent(type)
    }
}