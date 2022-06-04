package com.app.wordsphrases.add_word_impl.domain.use_case

import com.app.wordsphrases.add_word_api.domain.entity.*
import com.app.wordsphrases.add_word_impl.data.AddWordComponentsRepository
import com.app.wordsphrases.add_word_impl.di.*
import com.app.wordsphrases.add_word_impl.di.inner.*
import ru.terrakok.cicerone.Router
import java.util.*
import javax.inject.Inject

class CreateAddWordComponent @Inject constructor(
    private val addWordComponentsRepository: AddWordComponentsRepository,
) {

    operator fun invoke(
        uuid: UUID,
        type: AddWordComponentType,
        router: Router,
        initialTextWrapper: InitialTextWrapper
    ) {
        val innerComponent = when (type) {
            AddWordComponentType.Popup -> PopupAddWordInnerComponent.get(router, initialTextWrapper)
            AddWordComponentType.Regular -> RegularAddWordInnerComponent.get(router, initialTextWrapper)
        }

        val addWordParentComponent = AddWordParentComponent.get()
        val addWordComponent = AddWordComponent.create(
            addWordParentComponent = addWordParentComponent,
            addWordInnerComponent = innerComponent,
            type = type,
            uuid = uuid
        )
        addWordComponentsRepository.setAddWordComponent(uuid, addWordComponent)
    }
}