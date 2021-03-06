package com.app.wordsphrases.edit_word_impl.di

import com.app.wordsphrases.edit_word_api.domain.entity.EditWordType
import com.app.wordsphrases.edit_word_impl.presentation.add_word_screen.EditWordPresenter
import com.app.wordsphrases.core.AppComponent
import com.app.wordsphrases.core.BaseWordsPhrasesApp.Companion.appComponent
import dagger.*

@EditWordComponentScope
@Component(
    modules = [
        EditWordProvidesModule::class,
    ],
    dependencies = [
        AppComponent::class,
    ]
)
interface EditWordComponent {

    companion object {

        fun create(type: EditWordType): EditWordComponent {
            return DaggerEditWordComponent
                .factory()
                .create(
                    appComponent = appComponent,
                    type = type,
                )
        }
    }

    @Component.Factory
    interface Factory {

        fun create(
            appComponent: AppComponent,
            @BindsInstance type: EditWordType,
        ): EditWordComponent
    }

    val editWordPresenter: EditWordPresenter
}