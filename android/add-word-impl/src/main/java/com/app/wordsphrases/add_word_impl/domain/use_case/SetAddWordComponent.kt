package com.app.wordsphrases.add_word_impl.domain.use_case

import com.app.wordsphrases.add_word_impl.data.AddWordComponentsRepository
import com.app.wordsphrases.add_word_impl.di.AddWordComponent
import java.util.*
import javax.inject.Inject

class SetAddWordComponent @Inject constructor(
    private val addWordComponentsRepository: AddWordComponentsRepository,
) {

    operator fun invoke(uuid: UUID, component: AddWordComponent) {
        addWordComponentsRepository.setAddWordComponent(uuid, component)
    }
}