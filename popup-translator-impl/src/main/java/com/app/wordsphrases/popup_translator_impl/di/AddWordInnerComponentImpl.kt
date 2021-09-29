package com.app.wordsphrases.popup_translator_impl.di

import com.app.wordsphrases.add_word_api.di.AddWordInnerComponent
import com.app.wordsphrases.core.di.FeatureScope
import dagger.Component

@FeatureScope
@Component(
    modules = [
        PopupTranslatorRouterModule::class,
    ],
)
interface AddWordInnerComponentImpl : AddWordInnerComponent, PopupTranslatorInnerComponent {

    companion object {
        fun get(): AddWordInnerComponentImpl {
            return DaggerAddWordInnerComponentImpl.builder().build()
        }
    }
}