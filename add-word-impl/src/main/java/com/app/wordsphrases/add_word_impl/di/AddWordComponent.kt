package com.app.wordsphrases.add_word_impl.di

import com.app.wordsphrases.add_word_api.domain.entity.AddWordComponentType
import com.app.wordsphrases.add_word_impl.di.database.WordDatabaseComponent
import com.app.wordsphrases.add_word_impl.di.inner.AddWordInnerComponent
import com.app.wordsphrases.add_word_impl.presentation.enter_word_screen.EnterWordPresenter
import com.app.wordsphrases.add_word_impl.presentation.select_translation_fragment.SelectTranslationPresenter
import com.app.wordsphrases.core.AppComponent
import com.app.wordsphrases.core.BaseWordsPhrasesApp.Companion.appComponent
import dagger.BindsInstance
import dagger.Component

@AddWordComponentScope
@Component(
    dependencies = [
        AppComponent::class,
        WordDatabaseComponent::class,
        AddWordInnerComponent::class,
        AddWordParentComponent::class,
    ]
)
interface AddWordComponent {

    companion object {

        fun create(
            addWordParentComponent: AddWordParentComponent,
            addWordInnerComponent: AddWordInnerComponent,
            type: AddWordComponentType,
        ): AddWordComponent {
            return DaggerAddWordComponent
                .factory()
                .create(
                    appComponent = appComponent,
                    wordDatabaseComponent = WordDatabaseComponent.require(),
                    addWordInnerComponent = addWordInnerComponent,
                    addWordParentComponent = addWordParentComponent,
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
            addWordParentComponent: AddWordParentComponent,
            @BindsInstance type: AddWordComponentType,
        ): AddWordComponent
    }

    val selectTranslationPresenter: SelectTranslationPresenter

    val enterWordPresenter: EnterWordPresenter
}