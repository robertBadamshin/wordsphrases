package com.app.wordsphrases.add_word_impl.domain

import com.app.wordsphrases.add_word_api.di.AddWordInnerComponent
import com.app.wordsphrases.add_word_impl.data.AddWordComponentsRepository
import com.app.wordsphrases.add_word_impl.di.AddWordComponent
import javax.inject.Inject

class CreateAddWordComponent @Inject constructor(
    private val addWordComponentsRepository: AddWordComponentsRepository,
) {

    operator fun invoke(innerComponent: AddWordInnerComponent) {
        val addWordComponent = AddWordComponent.create(innerComponent)
        addWordComponentsRepository.setAddWordComponent(addWordComponent)
    }
}