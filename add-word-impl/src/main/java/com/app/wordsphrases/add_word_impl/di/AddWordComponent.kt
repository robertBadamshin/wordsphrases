package com.app.wordsphrases.add_word_impl.di

import com.app.wordsphrases.add_word_api.di.AddWordInnerComponent
import com.app.wordsphrases.add_word_api.domain.entity.AddWordComponentType
import com.app.wordsphrases.add_word_impl.di.database.WordDatabaseComponent
import com.app.wordsphrases.add_word_impl.presentation.enter_word_screen.EnterWordPresenter
import com.app.wordsphrases.add_word_impl.presentation.select_translation_fragment.SelectTranslationPresenter
import com.app.wordsphrases.core.AppComponent
import com.app.wordsphrases.core.BaseWordsPhrasesApp.Companion.appComponent
import com.app.wordsphrases.core.di.FeatureScope
import dagger.BindsInstance
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

        fun create(
            addWordInnerComponent: AddWordInnerComponent,
            type: AddWordComponentType,
        ): AddWordComponent {
            return DaggerAddWordComponent
                .factory()
                .create(
                    appComponent = appComponent,
                    wordDatabaseComponent = WordDatabaseComponent.require(),
                    addWordInnerComponent = addWordInnerComponent,
                    type = type,
                )
        }
    }

    @Component.Factory
    interface Factory {
        fun create(
            appComponent: AppComponent,
            wordDatabaseComponent: WordDatabaseComponent,
            addWordInnerComponent: AddWordInnerComponent,
            @BindsInstance type: AddWordComponentType,
        ): AddWordComponent
    }

    val selectTranslationPresenter: SelectTranslationPresenter

    val enterWordPresenter: EnterWordPresenter
}