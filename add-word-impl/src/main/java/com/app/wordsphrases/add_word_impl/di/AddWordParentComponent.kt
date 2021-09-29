package com.app.wordsphrases.add_word_impl.di

import com.app.wordsphrases.add_word_impl.domain.CreateAddWordComponent
import com.app.wordsphrases.add_word_impl.domain.CreatePopupAddWordComponent
import com.app.wordsphrases.add_word_impl.domain.RequireAddWordComponent
import com.app.wordsphrases.add_word_impl.domain.RequirePopupAddWordComponent
import com.app.wordsphrases.core.AppComponent
import com.app.wordsphrases.core.BaseWordsPhrasesApp.Companion.appComponent
import com.app.wordsphrases.core.di.FeatureScope
import dagger.Component

@FeatureScope
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

    val requirePopupAddWordComponent: RequirePopupAddWordComponent

    val createAddWordComponent: CreateAddWordComponent

    val requireAddWordComponent: RequireAddWordComponent

    val createPopupAddWordComponent: CreatePopupAddWordComponent
}