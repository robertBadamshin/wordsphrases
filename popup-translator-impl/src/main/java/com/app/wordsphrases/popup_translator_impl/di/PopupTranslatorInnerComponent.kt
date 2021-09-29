package com.app.wordsphrases.popup_translator_impl.di

import com.app.wordsphrases.popup_translator_impl.domain.entity.PopupTranslatorNavigatorHolderWrapper
import com.app.wordsphrases.popup_translator_impl.domain.entity.PopupTranslatorRouterWrapper

interface PopupTranslatorInnerComponent {

    val popupTranslatorRouterWrapper: PopupTranslatorRouterWrapper

    //@AddWordNavigationQualifier
    val popupTranslatorNavigatorHolderWrapper: PopupTranslatorNavigatorHolderWrapper
}