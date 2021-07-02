package com.app.wordsphrases.add_word_impl.di

import com.app.wordsphrases.add_word_impl.presentation.AddWordPresenter
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
interface AddWordComponent {

    companion object {

        fun get(): AddWordComponent {
            return DaggerAddWordComponent.builder()
                .appComponent(appComponent)
                .build()
        }
    }

    val addWordPresenter: AddWordPresenter
}