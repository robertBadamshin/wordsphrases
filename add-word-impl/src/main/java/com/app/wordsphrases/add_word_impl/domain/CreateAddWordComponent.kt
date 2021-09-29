package com.app.wordsphrases.add_word_impl.domain

import com.app.wordsphrases.add_word_api.domain.entity.AddWordComponentType
import com.app.wordsphrases.add_word_api.domain.entity.InitialTextWrapper
import com.app.wordsphrases.add_word_impl.data.AddWordComponentsRepository
import com.app.wordsphrases.add_word_impl.di.AddWordComponent
import com.app.wordsphrases.add_word_impl.di.AddWordParentComponent
import com.app.wordsphrases.add_word_impl.di.inner.PopupAddWordInnerComponent
import com.app.wordsphrases.add_word_impl.di.inner.RegularAddWordInnerComponent
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class CreateAddWordComponent @Inject constructor(
    private val addWordComponentsRepository: AddWordComponentsRepository,
) {

    operator fun invoke(type: AddWordComponentType, router: Router, initialTextWrapper: InitialTextWrapper) {
        val innerComponent = when (type) {
            AddWordComponentType.Popup -> PopupAddWordInnerComponent.get(router, initialTextWrapper)
            AddWordComponentType.Regular -> RegularAddWordInnerComponent.get(router, initialTextWrapper)
        }

        val addWordParentComponent = AddWordParentComponent.get()
        val addWordComponent = AddWordComponent.create(addWordParentComponent, innerComponent, type)
        addWordComponentsRepository.setAddWordComponent(type, addWordComponent)
    }
}