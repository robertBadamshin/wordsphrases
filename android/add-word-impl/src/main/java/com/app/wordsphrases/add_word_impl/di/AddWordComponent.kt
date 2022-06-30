package com.app.wordsphrases.add_word_impl.di

import com.app.wordsphrases.add_word_api.domain.entity.AddWordComponentType
import com.app.wordsphrases.add_word_impl.di.inner.AddWordInnerComponent
import com.app.wordsphrases.add_word_impl.presentation.add_word_screen.AddWordPresenter
import com.app.wordsphrases.core.AppComponent
import com.app.wordsphrases.core.BaseWordsPhrasesApp.Companion.appComponent
import dagger.*
import java.util.*

@AddWordComponentScope
@Component(
    modules = [
        AddWordProvidesModule::class,
    ],
    dependencies = [
        AppComponent::class,
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
            uuid: UUID,
        ): AddWordComponent {
            return DaggerAddWordComponent
                .factory()
                .create(
                    appComponent = appComponent,
                    addWordInnerComponent = addWordInnerComponent,
                    addWordParentComponent = addWordParentComponent,
                    type = type,
                    uuid = uuid,
                )
        }
    }

    @Component.Factory
    interface Factory {

        fun create(
            appComponent: AppComponent,
            addWordInnerComponent: AddWordInnerComponent,
            addWordParentComponent: AddWordParentComponent,
            @BindsInstance type: AddWordComponentType,
            @BindsInstance uuid: UUID,
        ): AddWordComponent
    }

    val addWordPresenter: AddWordPresenter
}