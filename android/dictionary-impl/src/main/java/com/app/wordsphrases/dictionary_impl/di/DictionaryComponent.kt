package com.app.wordsphrases.dictionary_impl.di

import com.app.wordsphrases.core.AppComponent
import com.app.wordsphrases.core.BaseWordsPhrasesApp.Companion.appComponent
import com.app.wordsphrases.core.di.FeatureScope
import com.app.wordsphrases.dictionary_impl.presentation.DictionaryPresenter
import dagger.Component

@FeatureScope
@Component(
    dependencies = [
        AppComponent::class,
    ],
    modules = [
        DictionaryModule::class,
    ]
)
interface DictionaryComponent {

    companion object {

        fun get(): DictionaryComponent {
            return DaggerDictionaryComponent.builder().appComponent(appComponent).build()
        }
    }

    val dictionaryPresenter: DictionaryPresenter
}