package com.app.wordsphrases.add_word_impl.domain

import com.app.wordsphrases.add_word_impl.data.AddWordComponentsRepository
import java.util.UUID
import javax.inject.Inject

class ClearAddWordComponent @Inject constructor(
    private val addWordComponentsRepository: AddWordComponentsRepository,
) {

    operator fun invoke(uuid: UUID) {
        addWordComponentsRepository.clearAddWordComponent(uuid)
    }
}