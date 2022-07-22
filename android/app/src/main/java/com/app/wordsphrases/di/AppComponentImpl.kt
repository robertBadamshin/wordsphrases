package com.app.wordsphrases.di

import android.content.Context
import com.app.wordsphrases.core.AppComponent
import com.app.wordsphrases.core.di.AppScope
import com.app.wordsphrases.dictionary_impl.di.DictionaryApiModule
import com.app.wordsphrases.edit_word_impl.di.EditWordApiModule
import com.app.wordsphrases.email_sender_impl.di.EmailSenderApiModule
import com.app.wordsphrases.home_impl.di.HomeApiModule
import com.app.wordsphrases.login_impl.di.LoginApiModule
import com.app.wordsphrases.presentation.*
import com.app.wordsphrases.remote_impl.di.RemoteApiModule
import com.app.wordsphrases.select_language_impl.di.SelectLanguageApiModule
import com.app.wordsphrases.stories_impl.di.*
import com.app.wordsphrases.word_detail_impl.di.WordDetailApiModule
import com.app.wordsphrases.words_stories_impl.di.WordsStoriesApiModule
import dagger.*

@AppScope
@Component(
    modules = [
        WordDetailApiModule::class,
        HomeApiModule::class,
        RemoteApiModule::class,
        StoriesApiModule::class,
        StoriesApiProvidesModule::class,
        EmailSenderApiModule::class,
        LoginApiModule::class,
        MainModule::class,
        SelectLanguageApiModule::class,
        DictionaryApiModule::class,
        WordDetailApiModule::class,
        EditWordApiModule::class,
        WordsStoriesApiModule::class,
    ]
)
interface AppComponentImpl : AppComponent {

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance context: Context,
        ): AppComponentImpl
    }

    fun inject(mainActivity: MainActivity)

    val mainPresenter: MainPresenter
}