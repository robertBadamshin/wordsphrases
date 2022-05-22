package com.app.wordsphrases.di

import android.content.Context
import com.app.wordsphrases.add_word_impl.di.AddWordApiModule
import com.app.wordsphrases.core.AppComponent
import com.app.wordsphrases.core.di.AppScope
import com.app.wordsphrases.email_sender_impl.di.EmailSenderApiModule
import com.app.wordsphrases.home_impl.di.HomeApiModule
import com.app.wordsphrases.login_impl.di.LoginApiModule
import com.app.wordsphrases.popup_translator_impl.di.StoriesApiModule
import com.app.wordsphrases.popup_translator_impl.di.StoriesApiProvidesModule
import com.app.wordsphrases.presentation.MainPresenter
import com.app.wordsphrases.remote_impl.di.RemoteApiModule
import com.app.wordsphrases.translation_impl.di.TranslationApiBindsModule
import com.app.wordsphrases.translation_impl.di.TranslationApiModule
import com.app.wordsphrases.translation_impl.di.oxford.OxfordDictionaryRetrofitModule
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(
    modules = [
        AddWordApiModule::class,
        HomeApiModule::class,
        RemoteApiModule::class,
        OxfordDictionaryRetrofitModule::class,
        TranslationApiModule::class,
        TranslationApiBindsModule::class,
        StoriesApiModule::class,
        StoriesApiProvidesModule::class,
        EmailSenderApiModule::class,
        LoginApiModule::class,
        MainModule::class,
    ]
)
interface AppComponentImpl : AppComponent {

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance context: Context,
        ): AppComponentImpl
    }

    val mainPresenter: MainPresenter
}