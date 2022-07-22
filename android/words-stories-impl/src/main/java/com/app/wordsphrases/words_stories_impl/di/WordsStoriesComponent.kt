package com.app.wordsphrases.words_stories_impl.di

import com.app.wordsphrases.core.AppComponent
import com.app.wordsphrases.core.BaseWordsPhrasesApp.Companion.appComponent
import com.app.wordsphrases.core.di.FeatureScope
import com.app.wordsphrases.words_stories_impl.presentation.WordStoriesPresenter
import dagger.Component

@FeatureScope
@Component(
    modules = [
        WordsStoriesProvidesModule::class,
    ],
    dependencies = [
        AppComponent::class,
    ]
)
interface WordsStoriesComponent {

    companion object {

        fun get(): WordsStoriesComponent {
            return DaggerWordsStoriesComponent.builder().appComponent(appComponent).build()
        }
    }

    val wordStoriesPresenter: WordStoriesPresenter
}