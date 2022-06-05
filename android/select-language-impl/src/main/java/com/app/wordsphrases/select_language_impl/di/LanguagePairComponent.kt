package com.app.wordsphrases.select_language_impl.di

import com.app.wordsphrases.core.AppComponent
import com.app.wordsphrases.core.BaseWordsPhrasesApp.Companion.appComponent
import dagger.Component

@Component(
    dependencies = [
        AppComponent::class,
    ]
)
interface LanguagePairComponent {

    companion object {
        fun get(): LanguagePairComponent {
            return DaggerLanguagePairComponent.builder().appComponent(appComponent).build()
        }
    }
}