package com.app.wordsphrases.popup_translator_impl.di

import com.app.wordsphrases.add_word_api.di.AddWordInnerRouterWrapper
import com.app.wordsphrases.add_word_api.di.AddWordNavigationQualifier
import com.app.wordsphrases.core.di.FeatureScope
import com.app.wordsphrases.popup_translator_impl.domain.entity.PopupTranslatorNavigatorHolderWrapper
import com.app.wordsphrases.popup_translator_impl.domain.entity.PopupTranslatorRouterWrapper
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
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
    fun providePopupTranslatorRouterWrapper(
        @AddWordNavigationQualifier router: Router,
    ): PopupTranslatorRouterWrapper {
        return PopupTranslatorRouterWrapper(router)
    }

    @Provides
    fun provideAddWordInnerRouterWrapper(
        @AddWordNavigationQualifier router: Router,
    ): AddWordInnerRouterWrapper {
        return AddWordInnerRouterWrapper(router)
    }

    @Provides
    fun provideNavigationHolder(
        @AddWordNavigationQualifier cicerone: Cicerone<Router>,
    ): PopupTranslatorNavigatorHolderWrapper {
        return PopupTranslatorNavigatorHolderWrapper(cicerone.navigatorHolder)
    }
}