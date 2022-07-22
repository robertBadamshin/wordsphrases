package com.app.wordsphrases.home_impl.di

import com.app.wordsphrases.core.AppComponent
import com.app.wordsphrases.core.BaseWordsPhrasesApp.Companion.appComponent
import com.app.wordsphrases.home_impl.presentation.HomePresenter
import dagger.Component

@Component(
    dependencies = [
        AppComponent::class,
    ]
)
interface HomeComponent {

    companion object {
        fun get(): HomeComponent {
            return DaggerHomeComponent.builder().appComponent(appComponent).build()
        }
    }

    val homePresenter: HomePresenter
}