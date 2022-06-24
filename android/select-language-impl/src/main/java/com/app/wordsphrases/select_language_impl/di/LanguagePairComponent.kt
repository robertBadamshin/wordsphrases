package com.app.wordsphrases.select_language_impl.di

import com.app.wordsphrases.core.AppComponent
import com.app.wordsphrases.core.BaseWordsPhrasesApp.Companion.appComponent
import com.app.wordsphrases.core.di.FeatureScope
import com.app.wordsphrases.select_language_impl.presentation.LanguagePairPresenter
import dagger.Component

@FeatureScope
@Component(
    dependencies = [
        AppComponent::class,
    ],
    modules = [
        LanguagePairProvidesModule::class,
    ]
)
interface LanguagePairComponent {

    companion object {

        fun get(): LanguagePairComponent {
            return DaggerLanguagePairComponent.builder().appComponent(appComponent).build()
        }
    }

    val languagePairPresenter: LanguagePairPresenter
}