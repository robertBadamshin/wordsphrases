package com.app.wordsphrases.add_word_impl.data

import com.app.wordsphrases.add_word_api.domain.entity.AddWordComponentType
import com.app.wordsphrases.add_word_impl.di.AddWordComponent
import com.app.wordsphrases.add_word_impl.di.AddWordParentComponentScope
import javax.inject.Inject

@AddWordParentComponentScope
class AddWordComponentsRepository @Inject constructor() {

    private var addWordComponents = mutableMapOf<AddWordComponentType, AddWordComponent>()

    fun setAddWordComponent(type: AddWordComponentType, component: AddWordComponent) {
       if (addWordComponents.containsKey(type)) {
            throw IllegalStateException("component already exists")
        }

        addWordComponents[type] = component
    }

    fun requireAddWordComponent(type: AddWordComponentType): AddWordComponent {
        return addWordComponents[type]
            ?: throw IllegalArgumentException(
                "${AddWordComponent::class.java.simpleName} with type $type should not be null"
            )
    }

    fun clearAddWordComponent(type: AddWordComponentType) {
        if (!addWordComponents.containsKey(type)) {
            throw IllegalStateException("component should be presented")
        }

        addWordComponents.remove(type)
    }
}