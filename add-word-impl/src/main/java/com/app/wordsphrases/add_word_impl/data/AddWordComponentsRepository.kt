package com.app.wordsphrases.add_word_impl.data

import com.app.wordsphrases.add_word_impl.di.AddWordComponent
import com.app.wordsphrases.core.di.FeatureScope
import javax.inject.Inject

@FeatureScope
class AddWordComponentsRepository @Inject constructor() {


    private var addWordComponent: AddWordComponent? = null

    private var popupAddWordComponent: AddWordComponent? = null

    fun setAddWordComponent(component: AddWordComponent) {
        addWordComponent = component
    }

    fun requireAddWordComponent(): AddWordComponent {
        return addWordComponent
            ?: throw IllegalArgumentException("${AddWordComponent::class.java.simpleName} should be null")
    }

    fun clearAddWordComponent() {
        addWordComponent = null
    }

    fun setPopupAddWordComponent(component: AddWordComponent) {
        popupAddWordComponent = component
    }

    fun requirePopupAddWordComponent(): AddWordComponent {
        return popupAddWordComponent
            ?: throw IllegalArgumentException("${AddWordComponent::class.java.simpleName} should be null")
    }

    fun clearPopupAddWordComponent() {
        popupAddWordComponent = null
    }
}