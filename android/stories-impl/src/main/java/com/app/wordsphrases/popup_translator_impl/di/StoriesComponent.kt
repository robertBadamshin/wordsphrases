package com.app.wordsphrases.popup_translator_impl.di

import com.app.wordsphrases.core.AppComponent
import com.app.wordsphrases.core.BaseWordsPhrasesApp.Companion.appComponent
import com.app.wordsphrases.core.di.FeatureScope
import com.app.wordsphrases.popup_translator_impl.presentation.StoriesPresenter
import dagger.Component

@FeatureScope
@Component(
    dependencies = [
        AppComponent::class,
    ]
)
interface StoriesComponent {

    companion object {
        fun get(): StoriesComponent {
            return DaggerStoriesComponent.builder().appComponent(appComponent).build()
        }
    }

    val storiesPresenter: StoriesPresenter
}