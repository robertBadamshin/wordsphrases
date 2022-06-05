package com.app.wordsphrases.select_language_impl.di

import com.app.wordsphrases.core.AppComponent
import com.app.wordsphrases.core.BaseWordsPhrasesApp.Companion.appComponent
import com.app.wordsphrases.core.di.FeatureScope
import com.app.wordsphrases.select_language_impl.presentation.SelectLanguagePresenter
import dagger.Component

@FeatureScope
@Component(
    dependencies = [
        AppComponent::class,
    ]
)
interface SelectLanguageComponent {

    companion object {

        fun get(): SelectLanguageComponent {
            return DaggerSelectLanguageComponent.builder().appComponent(appComponent).build()
        }
    }

    val selectLanguagePresenter: SelectLanguagePresenter
}