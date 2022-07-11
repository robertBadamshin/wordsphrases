package com.app.wordsphrases.word_detail_impl.di

import com.app.wordsphrases.core.AppComponent
import com.app.wordsphrases.core.BaseWordsPhrasesApp.Companion.appComponent
import com.app.wordsphrases.core.di.FeatureScope
import com.app.wordsphrases.word_detail_impl.domain.entity.WordIdHolder
import com.app.wordsphrases.word_detail_impl.presentation.WordDetailsPresenter
import dagger.*

@FeatureScope
@Component(
    modules = [
        WordDetailsProvidesModule::class,
    ],
    dependencies = [
        AppComponent::class,
    ]
)
interface WordDetailsComponent {

    companion object {

        fun get(wordIdHolder: WordIdHolder): WordDetailsComponent {
            return DaggerWordDetailsComponent
                .factory()
                .create(
                    appComponent = appComponent,
                    wordIdHolder = wordIdHolder,
                )
        }
    }

    @Component.Factory
    interface Factory {

        fun create(
            appComponent: AppComponent,
            @BindsInstance wordIdHolder: WordIdHolder,
        ): WordDetailsComponent
    }

    val wordDetailsPresenter: WordDetailsPresenter
}