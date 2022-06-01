package com.app.wordsphrases.stories_impl.di

import com.app.wordsphrases.core.AppComponent
import com.app.wordsphrases.core.BaseWordsPhrasesApp.Companion.appComponent
import com.app.wordsphrases.core.di.FeatureScope
import com.app.wordsphrases.popup_translator_impl.di.DaggerStoriesComponent
import com.app.wordsphrases.stories_impl.presentation.StoriesPresenter
import dagger.Component

@FeatureScope
@Component(
    modules = [
        StoriesProvidesModule::class,
    ],
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