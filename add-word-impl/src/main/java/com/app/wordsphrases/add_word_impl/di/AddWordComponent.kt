package com.app.wordsphrases.add_word_impl.di

import com.app.wordsphrases.add_word_impl.di.database.WordDatabaseComponent
import com.app.wordsphrases.add_word_impl.presentation.add_word_screen.SelectTranslationPresenter
import com.app.wordsphrases.add_word_impl.presentation.enter_word_screen.EnterWordPresenter
import com.app.wordsphrases.core.AppComponent
import com.app.wordsphrases.core.BaseWordsPhrasesApp.Companion.appComponent
import com.app.wordsphrases.core.di.FeatureScope
import dagger.Component

@FeatureScope
@Component(
    dependencies = [
        AppComponent::class,
        WordDatabaseComponent::class,
    ]
)
interface AddWordComponent {

    companion object {

        private var component: AddWordComponent? = null

        fun get(): AddWordComponent {
            return synchronized(this) {
                val component = component
                if (component != null) {
                    component
                } else {
                    val newComponent = DaggerAddWordComponent.builder()
                        .appComponent(appComponent)
                        .wordDatabaseComponent(WordDatabaseComponent.require())
                        .build()
                    Companion.component = newComponent
                    newComponent
                }
            }
        }

        fun clear() {
            component = null
        }
    }

    val selectTranslationPresenter: SelectTranslationPresenter

    val enterWordPresenter: EnterWordPresenter
}