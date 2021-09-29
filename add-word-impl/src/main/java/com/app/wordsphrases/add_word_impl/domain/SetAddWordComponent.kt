package com.app.wordsphrases.add_word_impl.domain

import com.app.wordsphrases.add_word_api.domain.entity.AddWordComponentType
import com.app.wordsphrases.add_word_impl.data.AddWordComponentsRepository
import com.app.wordsphrases.add_word_impl.di.AddWordComponent
import javax.inject.Inject

class SetAddWordComponent @Inject constructor(
    private val addWordComponentsRepository: AddWordComponentsRepository,
) {

    operator fun invoke(type: AddWordComponentType, component: AddWordComponent) {
        addWordComponentsRepository.setAddWordComponent(type, component)
    }
}