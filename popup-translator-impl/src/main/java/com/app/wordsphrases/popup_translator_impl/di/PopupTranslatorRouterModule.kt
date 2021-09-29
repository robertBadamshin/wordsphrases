package com.app.wordsphrases.popup_translator_impl.di

import com.app.wordsphrases.add_word_api.di.AddWordNavigationQualifier
import com.app.wordsphrases.core.di.FeatureScope
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

@Module
class PopupTranslatorRouterModule {

    @Provides
    @FeatureScope
    @AddWordNavigationQualifier
    fun provideCicerone(): Cicerone<Router> {
        return Cicerone.create(Router())
    }

    @Provides
    @AddWordNavigationQualifier
    fun provideRouter(@AddWordNavigationQualifier cicerone: Cicerone<Router>): Router {
        return cicerone.router
    }

    @Provides
    @PopupTranslatorNavigationQualifier
    fun providePopupTranslationRouter(@AddWordNavigationQualifier cicerone: Cicerone<Router>): Router {
        return cicerone.router
    }

    @Provides
    @PopupTranslatorNavigationQualifier
    fun provideNavigationHolder(
        @AddWordNavigationQualifier cicerone: Cicerone<Router>,
    ): NavigatorHolder {
        return cicerone.navigatorHolder
    }
}