package com.app.wordsphrases.add_word_impl.domain

import com.app.wordsphrases.add_word_impl.data.AddWordComponentsRepository
import com.app.wordsphrases.add_word_impl.di.AddWordComponent
import java.util.UUID
import javax.inject.Inject

class SetAddWordComponent @Inject constructor(
    private val addWordComponentsRepository: AddWordComponentsRepository,
) {

    operator fun invoke(uuid: UUID, component: AddWordComponent) {
        addWordComponentsRepository.setAddWordComponent(uuid, component)
    }
}