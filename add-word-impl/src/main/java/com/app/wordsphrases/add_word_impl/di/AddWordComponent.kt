package com.app.wordsphrases.add_word_impl.di

import com.app.wordsphrases.add_word_api.di.AddWordInnerComponent
import com.app.wordsphrases.add_word_impl.di.database.WordDatabaseComponent
import com.app.wordsphrases.add_word_impl.presentation.enter_word_screen.EnterWordPresenter
import com.app.wordsphrases.add_word_impl.presentation.select_translation_fragment.SelectTranslationPresenter
import com.app.wordsphrases.core.AppComponent
import com.app.wordsphrases.core.BaseWordsPhrasesApp.Companion.appComponent
import com.app.wordsphrases.core.di.FeatureScope
import dagger.Component

@FeatureScope
@Component(
    dependencies = [
        AppComponent::class,
        WordDatabaseComponent::class,
        AddWordInnerComponent::class,
    ]
)
interface AddWordComponent {

    companion object {

        private var component: AddWordComponent? = null

        fun create(addWordInnerComponent: AddWordInnerComponent): AddWordComponent {
//            return synchronized(this) {
//                val component = component
//                if (component != null) {
//                    component
//                } else {
//                    val newComponent = DaggerAddWordComponent
//                        .factory()
//                        .create(
//                            appComponent,
//                            WordDatabaseComponent.require(),
//                            addWordInnerComponent,
//                        )
//                    Companion.component = newComponent
//                    newComponent
//                }
//            }
            return DaggerAddWordComponent
                .factory()
                .create(
                    appComponent,
                    WordDatabaseComponent.require(),
                    addWordInnerComponent,
                )
        }

        fun require(): AddWordComponent {
            return component!!
        }

        fun clear() {
            component = null
        }
    }

    @Component.Factory
    interface Factory {
        fun create(
            appComponent: AppComponent,
            wordDatabaseComponent: WordDatabaseComponent,
            addWordInnerComponent: AddWordInnerComponent,
        ): AddWordComponent
    }

    val selectTranslationPresenter: SelectTranslationPresenter

    val enterWordPresenter: EnterWordPresenter
}