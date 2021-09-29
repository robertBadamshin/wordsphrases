package com.app.wordsphrases.popup_translator_impl.di

import com.app.wordsphrases.add_word_api.di.AddWordInnerComponent
import com.app.wordsphrases.add_word_api.di.AddWordInnerRouterWrapper
import com.app.wordsphrases.core.di.FeatureScope
import dagger.BindsInstance
import dagger.Component

@FeatureScope
@Component
interface RegularAddWordInnerComponentImpl : AddWordInnerComponent {

    companion object {
        fun get(addWordInnerRouterWrapper: AddWordInnerRouterWrapper): RegularAddWordInnerComponentImpl {
            return DaggerRegularAddWordInnerComponentImpl.factory().create(addWordInnerRouterWrapper)
        }
    }

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance addWordInnerRouterWrapper: AddWordInnerRouterWrapper,
        ): RegularAddWordInnerComponentImpl
    }
}