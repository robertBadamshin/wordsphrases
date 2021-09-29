package com.app.wordsphrases.popup_translator_impl.di

import com.app.wordsphrases.core.AppComponent
import com.app.wordsphrases.core.BaseWordsPhrasesApp.Companion.appComponent
import com.app.wordsphrases.core.di.FeatureScope
import com.app.wordsphrases.popup_translator_impl.presentation.PopupTranslatorPresenter
import dagger.Component
import ru.terrakok.cicerone.NavigatorHolder

@FeatureScope
@Component(
    dependencies = [
        AppComponent::class,
        PopupTranslatorInnerComponent::class,
    ],
)
interface PopupTranslatorComponent {

    companion object {

        fun get(component: PopupTranslatorInnerComponent): PopupTranslatorComponent {
            return DaggerPopupTranslatorComponent.builder()
                .appComponent(appComponent)
                .popupTranslatorInnerComponent(component)
                .build()
        }
    }

    @get:PopupTranslatorNavigationQualifier
    val popupTranslatorNavigatorHolder: NavigatorHolder

    val popupTranslatorPresenter: PopupTranslatorPresenter
}