package com.app.wordsphrases.popup_translator_impl.di

import com.app.wordsphrases.core.AppComponent
import com.app.wordsphrases.core.BaseWordsPhrasesApp.Companion.appComponent
import com.app.wordsphrases.core.di.FeatureScope
import com.app.wordsphrases.popup_translator_impl.presentation.PopupTranslatorPresenter
import dagger.Component

@FeatureScope
@Component(
    dependencies = [
        AppComponent::class,
    ]
)
interface PopupTranslatorComponent {

    companion object {
        fun get(): PopupTranslatorComponent {
            return DaggerPopupTranslatorComponent.builder().appComponent(appComponent).build()
        }
    }

    val popupTranslatorPresenter: PopupTranslatorPresenter
}