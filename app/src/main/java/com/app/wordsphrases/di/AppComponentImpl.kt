package com.app.wordsphrases.di

import android.content.Context
import com.app.wordsphrases.add_word_impl.di.AddWordApiModule
import com.app.wordsphrases.add_word_impl.di.database.WordDatabaseComponent
import com.app.wordsphrases.core.AppComponent
import com.app.wordsphrases.core.di.AppScope
import com.app.wordsphrases.email_sender_impl.di.EmailSenderApiModule
import com.app.wordsphrases.home_impl.di.HomeApiModule
import com.app.wordsphrases.popup_translator_impl.di.StoriesApiModule
import com.app.wordsphrases.popup_translator_impl.di.StoriesApiProvidesModule
import com.app.wordsphrases.presentation.MainPresenter
import com.app.wordsphrases.remote_impl.di.RemoteApiModule
import com.app.wordsphrases.translation_impl.di.TranslationApiBindsModule
import com.app.wordsphrases.translation_impl.di.TranslationApiModule
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(
    dependencies = [
        WordDatabaseComponent::class,
    ],
    modules = [
        AddWordApiModule::class,
        HomeApiModule::class,
        RemoteApiModule::class,
        TranslationApiModule::class,
        TranslationApiBindsModule::class,
        StoriesApiModule::class,
        StoriesApiProvidesModule::class,
        EmailSenderApiModule::class,
    ]
)
interface AppComponentImpl : AppComponent {

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance context: Context,
            wordDatabaseComponent: WordDatabaseComponent,
        ): AppComponentImpl
    }

    val mainPresenter: MainPresenter
}