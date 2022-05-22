package com.app.wordsphrases.login_impl.di

import com.app.wordsphrases.core.*
import com.app.wordsphrases.login_impl.presentation.EnterEmailPresenter
import dagger.Component

@Component(
    modules = [
        EnterEmailModule::class,
    ],
    dependencies = [
        AppComponent::class,
    ]
)
interface EnterEmailComponent {

    companion object {

        private var component: EnterEmailComponent? = null

        fun get(): EnterEmailComponent {
            return synchronized(this) {
                val component = component
                if (component != null) {
                    component
                } else {
                    val newComponent = DaggerEnterEmailComponent.builder()
                        .appComponent(BaseWordsPhrasesApp.appComponent)
                        .build()
                    Companion.component = newComponent
                    newComponent
                }
            }
        }

        fun clear() {
            component = null
        }
    }

    val enterEmailPresenter: EnterEmailPresenter
}