package com.app.wordsphrases.popup_translator_impl.di

import com.app.wordsphrases.core.di.FeatureScope
import dagger.*
import ru.terrakok.cicerone.*

@Module
class PopupTranslatorRouterModule {

    @Provides
    @FeatureScope
    @PopupTranslatorNavigationQualifier
    fun provideCicerone(): Cicerone<Router> {
        return Cicerone.create(Router())
    }

    @Provides
    @PopupTranslatorNavigationQualifier
    fun providePopupTranslationRouter(@PopupTranslatorNavigationQualifier cicerone: Cicerone<Router>): Router {
        return cicerone.router
    }

    @Provides
    @PopupTranslatorNavigationQualifier
    fun provideNavigationHolder(
        @PopupTranslatorNavigationQualifier cicerone: Cicerone<Router>,
    ): NavigatorHolder {
        return cicerone.navigatorHolder
    }
}