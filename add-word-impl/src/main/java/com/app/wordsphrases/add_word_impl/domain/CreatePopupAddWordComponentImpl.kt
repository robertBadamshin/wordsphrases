package com.app.wordsphrases.add_word_impl.domain

import com.app.wordsphrases.add_word_api.di.AddWordInnerComponent
import com.app.wordsphrases.add_word_api.domain.CreatePopupAddWordComponent
import com.app.wordsphrases.add_word_impl.data.AddWordComponentsRepository
import com.app.wordsphrases.add_word_impl.di.AddWordComponent
import javax.inject.Inject

class CreatePopupAddWordComponentImpl @Inject constructor(
    private val addWordComponentsRepository: AddWordComponentsRepository,
) : CreatePopupAddWordComponent {

    override operator fun invoke(innerComponent: AddWordInnerComponent) {
        val addWordComponent = AddWordComponent.create(innerComponent)
        addWordComponentsRepository.setPopupAddWordComponent(addWordComponent)
    }
}