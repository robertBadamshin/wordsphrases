package com.app.wordsphrases.add_word_impl.data

import com.app.wordsphrases.add_word_impl.di.AddWordComponent
import com.app.wordsphrases.add_word_impl.di.AddWordParentComponentScope
import java.util.UUID
import javax.inject.Inject

@AddWordParentComponentScope
class AddWordComponentsRepository @Inject constructor() {

    private var addWordComponents = mutableMapOf<UUID, AddWordComponent>()

    fun setAddWordComponent(uuid: UUID, component: AddWordComponent) {
        if (addWordComponents.containsKey(uuid)) {
            throw IllegalStateException("component already exists")
        }

        addWordComponents[uuid] = component
    }

    fun requireAddWordComponent(uuid: UUID): AddWordComponent {
        return addWordComponents[uuid]
            ?: throw IllegalArgumentException(
                "${AddWordComponent::class.java.simpleName} with key $uuid should not be null"
            )
    }

    fun clearAddWordComponent(uuid: UUID) {
        if (!addWordComponents.containsKey(uuid)) {
            throw IllegalStateException("component should be presented")
        }

        addWordComponents.remove(uuid)
    }
}