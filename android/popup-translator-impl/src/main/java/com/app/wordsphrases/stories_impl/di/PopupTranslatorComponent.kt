package com.app.wordsphrases.stories_impl.di

import com.app.wordsphrases.add_word_api.domain.entity.InitialTextWrapper
import com.app.wordsphrases.core.AppComponent
import com.app.wordsphrases.core.BaseWordsPhrasesApp.Companion.appComponent
import com.app.wordsphrases.core.di.FeatureScope
import com.app.wordsphrases.stories_impl.presentation.PopupTranslatorPresenter
import dagger.*
import ru.terrakok.cicerone.NavigatorHolder

@FeatureScope
@Component(
    modules = [
        PopupTranslatorRouterModule::class,
    ],
    dependencies = [
        AppComponent::class,
    ],
)
interface PopupTranslatorComponent {

    companion object {

        fun get(initialTextWrapper: InitialTextWrapper): PopupTranslatorComponent {
            return DaggerPopupTranslatorComponent.factory()
                .create(appComponent, initialTextWrapper)
        }
    }

    @Component.Factory
    interface Factory {

        fun create(
            appComponent: AppComponent,
            @BindsInstance initialTextWrapper: InitialTextWrapper,
        ): PopupTranslatorComponent
    }


    @get:PopupTranslatorNavigationQualifier
    val popupTranslatorNavigatorHolder: NavigatorHolder

    val popupTranslatorPresenter: PopupTranslatorPresenter
}