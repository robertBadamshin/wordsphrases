package com.app.wordsphrases.add_word_impl.di

import com.app.wordsphrases.add_word_impl.domain.*
import com.app.wordsphrases.core.AppComponent
import com.app.wordsphrases.core.BaseWordsPhrasesApp.Companion.appComponent
import dagger.Component

@AddWordParentComponentScope
@Component(
    dependencies = [
        AppComponent::class,
    ]
)
interface AddWordParentComponent {

    companion object {

        private var component: AddWordParentComponent? = null

        fun get(): AddWordParentComponent {
            return synchronized(this) {
                val component = component
                if (component != null) {
                    component
                } else {
                    val newComponent = DaggerAddWordParentComponent.builder()
                        .appComponent(appComponent)
                        .build()
                    Companion.component = newComponent
                    newComponent
                }
            }

            fun clear() {
                component = null
            }
        }
    }

    val createAddWordComponent: CreateAddWordComponent

    val requireAddWordComponent: RequireAddWordComponent

    val clearAddWordComponent: ClearAddWordComponent
}