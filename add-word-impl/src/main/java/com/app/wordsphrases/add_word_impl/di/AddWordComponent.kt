package com.app.wordsphrases.add_word_impl.di

import com.app.wordsphrases.add_word_impl.presentation.add_word_screen.AddWordPresenter
import com.app.wordsphrases.add_word_impl.presentation.enter_word_screen.EnterWordPresenter
import com.app.wordsphrases.core.AppComponent
import com.app.wordsphrases.core.BaseWordsPhrasesApp.Companion.appComponent
import com.app.wordsphrases.core.di.FeatureScope
import dagger.Component

@FeatureScope
@Component(
    dependencies = [
        AppComponent::class,
    ],
    modules = [
        AddWordModule::class,
    ]
)
interface AddWordComponent {

    companion object {

        fun get(): AddWordComponent {
            return DaggerAddWordComponent.builder()
                .appComponent(appComponent)
                .build()
        }
    }

    val addWordPresenter: AddWordPresenter

    val enterWordPresenter: EnterWordPresenter
}