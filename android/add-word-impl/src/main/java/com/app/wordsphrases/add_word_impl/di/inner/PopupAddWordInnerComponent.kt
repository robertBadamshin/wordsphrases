package com.app.wordsphrases.add_word_impl.di.inner

import com.app.wordsphrases.add_word_api.domain.entity.InitialTextWrapper
import com.app.wordsphrases.add_word_impl.di.AddWordNavigationQualifier
import com.app.wordsphrases.core.di.FeatureScope
import dagger.BindsInstance
import dagger.Component
import ru.terrakok.cicerone.Router

@FeatureScope
@Component
interface PopupAddWordInnerComponent : AddWordInnerComponent {

    companion object {
        fun get(router: Router, initialTextWrapper: InitialTextWrapper): PopupAddWordInnerComponent {
            return DaggerPopupAddWordInnerComponent.factory()
                .create(
                    router,
                    initialTextWrapper,
                )
        }
    }

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @AddWordNavigationQualifier router: Router,
            @BindsInstance initialTextWrapper: InitialTextWrapper,
        ): PopupAddWordInnerComponent
    }


}